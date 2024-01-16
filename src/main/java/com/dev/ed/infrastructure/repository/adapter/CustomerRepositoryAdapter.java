package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.helper.audithelper.CustomerAuditHelper;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.util.common.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerOut {

    private final CustomerRepository customerRepository;
    @Override
    public ResponseBase create(RequestCustomer request) {
        CustomerEntity customerEntity = CustomerMapper.MAPPER.mapToCustomerEntity(request);
        CustomerAuditHelper.setCustomerAuditCreate(customerEntity,"emoran");
        ResponseCustomer responseCustomerSaved = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntity));
        return new ResponseBase("Guardado ok", Optional.of(responseCustomerSaved));
    }

    @Override
    public ResponseBase update(Long code, RequestCustomer request) {
        CustomerEntity customerEntity = customerRepository.findById(code).orElseThrow(() -> new IdNotFoundException(TablesName.cliente.name()));
        CustomerEntity customerEntityUpdate = CustomerMapper.MAPPER.mapRequestToEntity(request, customerEntity);
        CustomerAuditHelper.setCustomerAuditModif(customerEntityUpdate, "emoran");
        ResponseCustomer responseCustomerUpdated = CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntityUpdate));
        return new ResponseBase("registro actualizado", Optional.of(responseCustomerUpdated));
    }

    @Override
    public ResponseBase get(Long code) {
        return null;
    }

    @Override
    public List<ResponseBase> getAll() {
        return null;
    }
}
