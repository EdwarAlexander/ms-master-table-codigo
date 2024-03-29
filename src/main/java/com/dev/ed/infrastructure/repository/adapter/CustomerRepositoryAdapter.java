package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.infrastructure.config.RedisService;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.feignclient.ReniecClient;
import com.dev.ed.infrastructure.helper.audithelper.CustomerAuditHelper;
import com.dev.ed.infrastructure.helper.mappers.CustomerApiMapper;
import com.dev.ed.infrastructure.helper.response.ReniecResponseHelper;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.OperationUtil;
import com.dev.ed.infrastructure.util.common.RedisUtil;
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.CustomerMapper;
import com.dev.ed.infrastructure.util.mapper.PaginationMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CustomerOut {
    public CustomerRepositoryAdapter(CustomerRepository customerRepository, ReniecClient reniecClient, RedisService redisService) {
        this.customerRepository = customerRepository;
        this.reniecClient = reniecClient;
        this.redisService = redisService;
    }

    private final CustomerRepository customerRepository;
    private final ReniecClient reniecClient;

    private final RedisService redisService;

    @Value("${token.api.reniec}")
    public String tokenReniec;
    @Override
    public ResponseBase<ResponseCustomer> create(RequestCustomer request) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = CustomerMapper.MAPPER.mapToCustomerEntity(request);
        CustomerAuditHelper.setCustomerAuditCreate(customerEntity, ConstantUtil.DEFAULT_USER);
        ResponseCustomer responseCustomerSaved = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntity));
        result.setMessage("Guardado Ok");
        result.setData(responseCustomerSaved);
        return result;
    }

    @Override
    public ResponseBase<ResponseCustomer> update(Long code, RequestCustomer request) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(() -> new IdNotFoundException(TablesName.CLIENTE.name()));
        CustomerEntity customerEntityUpdate = CustomerMapper.MAPPER.mapRequestToEntity(request, customerEntity);
        CustomerAuditHelper.setCustomerAuditModif(customerEntityUpdate, ConstantUtil.DEFAULT_USER);
        ResponseCustomer responseCustomerUpdated = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntityUpdate));
        result.setMessage("Actualizado Ok");
        result.setData(responseCustomerUpdated);
        return result;
    }

    @Override
    public ResponseBase<ResponseCustomer> get(Long code) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.CLIENTE.name()));
        ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerEntity);
        result.setData(responseCustomer);
        result.setMessage("registro encontrado");
        return result;
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAll() {
        ResponseBase<List<ResponseCustomer>> result = new ResponseBase<>();
        List<CustomerEntity> customerList = customerRepository.findAll();
        List<ResponseCustomer> responseCustomerList = CustomerMapper.MAPPER.mapToResponseCustomerList(customerList);
        result.setData(responseCustomerList);
        result.setMessage("registro encontrado");
        return result;
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseCustomer>> result = new ResponseBase<>();
        Page<CustomerEntity> customerEntityPage = customerRepository.findAll(PageRequest.of(page,limit, OperationUtil.createSort(sort,"id")));
        if(customerEntityPage.isEmpty()){
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(customerEntityPage.getNumber(),customerEntityPage.getNumberOfElements(),customerEntityPage.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(CustomerMapper.MAPPER.mapToResponseCustomerList(customerEntityPage.getContent()));
        }
        return result;
    }

    @Override
    public ResponseBase<ResponseCustomer> createToApiClient(String document) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        Optional<CustomerEntity> customerEntity = customerRepository.findByDocumento(document);
        if(customerEntity.isPresent()){
            ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerEntity.get());
            result.setMessage("Registro encontrado");
            result.setData(responseCustomer);
            return result;
        } else {
            CustomerEntity customer = getApiClient(document);
            CustomerAuditHelper.setCustomerAuditCreate(customer, ConstantUtil.DEFAULT_USER);
            ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customer));
            result.setMessage("Registro encontrado APi");
            result.setData(responseCustomer);
            return result;
        }
    }

    @Override
    public ResponseBase<ResponseCustomer> getDocumentCustomer(String document) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        String redisCache = redisService.getValueByKey(ConstantUtil.REDIS_KEY_INFO_RENIEC+document);
        if(redisCache!= null){
            CustomerEntity customerEntityRedis = RedisUtil.convertFromJson(redisCache, CustomerEntity.class);
            ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerEntityRedis);
            result.setMessage("Registro encontrado Redis");
            result.setData(responseCustomer);
        } else {
            Optional<CustomerEntity> customerEntity = customerRepository.findByDocumento(document);
            String redisData = RedisUtil.convertToJson(customerEntity.get());
            redisService.saveKeyValue(ConstantUtil.REDIS_KEY_INFO_RENIEC+document,redisData,1);
            ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerEntity.get());
            result.setMessage("Registro encontrado Guardado Redis");
            result.setData(responseCustomer);
        }
        return result;
    }

    private CustomerEntity getApiClient(String document){
        String token = "Bearer "+tokenReniec;
        ReniecResponseHelper reniecResponseHelper = reniecClient.getInfoReniec(document,token);
        return CustomerApiMapper.mapToCustomerEntityApi(reniecResponseHelper);
    }
}
