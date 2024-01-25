package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.helper.audithelper.CustomerAuditHelper;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.util.common.OperationUtil;
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.CustomerMapper;
import com.dev.ed.infrastructure.util.mapper.PaginationMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerOut {

    private final CustomerRepository customerRepository;
    @Override
    public ResponseBase<ResponseCustomer> create(RequestCustomer request) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = CustomerMapper.MAPPER.mapToCustomerEntity(request);
        CustomerAuditHelper.setCustomerAuditCreate(customerEntity,"emoran");
        ResponseCustomer responseCustomerSaved = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntity));
        result.setMessage("Guardado Ok");
        result.setData(responseCustomerSaved);
        return result;
    }

    @Override
    public ResponseBase<ResponseCustomer> update(Long code, RequestCustomer request) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(() -> new IdNotFoundException(TablesName.cliente.name()));
        CustomerEntity customerEntityUpdate = CustomerMapper.MAPPER.mapRequestToEntity(request, customerEntity);
        CustomerAuditHelper.setCustomerAuditModif(customerEntityUpdate, "emoran");
        ResponseCustomer responseCustomerUpdated = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntityUpdate));
        result.setMessage("Actualizado Ok");
        result.setData(responseCustomerUpdated);
        return result;
    }

    @Override
    public ResponseBase<ResponseCustomer> get(Long code) {
        ResponseBase<ResponseCustomer> result = new ResponseBase<>();
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.cliente.name()));
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
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0L,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(customerEntityPage.getNumber(),customerEntityPage.getTotalElements(),customerEntityPage.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(CustomerMapper.MAPPER.mapToResponseCustomerList(customerEntityPage.getContent()));
        }
        return result;
    }
}
