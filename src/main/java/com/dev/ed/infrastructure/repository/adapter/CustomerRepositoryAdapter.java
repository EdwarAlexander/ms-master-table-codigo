package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.helper.audithelper.CustomerAuditHelper;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerOut {

    private final CustomerRepository customerRepository;
    @Override
    public ResponseBase<ResponseCustomer> create(RequestCustomer request) {
        CustomerEntity customerEntity = CustomerMapper.MAPPER.mapToCustomerEntity(request);
        CustomerAuditHelper.setCustomerAuditCreate(customerEntity,"emoran");
        ResponseCustomer responseCustomerSaved = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntity));
        return new ResponseBase<>("Guardado ok", responseCustomerSaved);
    }

    @Override
    public ResponseBase<ResponseCustomer> update(Long code, RequestCustomer request) {
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(() -> new IdNotFoundException(TablesName.cliente.name()));
        CustomerEntity customerEntityUpdate = CustomerMapper.MAPPER.mapRequestToEntity(request, customerEntity);
        CustomerAuditHelper.setCustomerAuditModif(customerEntityUpdate, "emoran");
        ResponseCustomer responseCustomerUpdated = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntityUpdate));
        return new ResponseBase<>("registro actualizado", responseCustomerUpdated);
    }

    @Override
    public ResponseBase<ResponseCustomer> get(Long code) {
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.cliente.name()));
        ResponseCustomer responseCustomer = CustomerMapper.MAPPER.mapToResponseCustomer(customerEntity);
        return new ResponseBase<>("registro encontrado", responseCustomer);
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAll() {
        List<CustomerEntity> customerList = customerRepository.findAll();
        List<ResponseCustomer> responseCustomerList = CustomerMapper.MAPPER.mapToResponseCustomerList(customerList);
        return new ResponseBase<>("Listado", responseCustomerList);
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAllPagination(Integer page, Integer limit, String sort) {
        return null;
    }
}
