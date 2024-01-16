package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.helper.audithelper.CustomerAuditHelper;
import com.dev.ed.infrastructure.repository.CustomerRepository;
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
    public ResponseCustomer create(RequestCustomer request) {
        CustomerEntity customerEntity = CustomerMapper.MAPPER.mapToCustomerEntity(request);
        CustomerAuditHelper.setCustomerAuditCreate(customerEntity,"emoran");
        return CustomerMapper.MAPPER.mapToResponseCustomer(customerRepository.save(customerEntity));
    }

    @Override
    public Optional<ResponseCustomer> update(Long code, RequestCustomer request) {
        return Optional.empty();
    }

    @Override
    public Optional<ResponseCustomer> get(Long code) {
        return Optional.empty();
    }

    @Override
    public List<ResponseCustomer> getAll() {
        return null;
    }
}
