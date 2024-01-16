package com.dev.ed.application.service;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.in.CustomerIn;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class CustomerService implements CustomerIn {

    private final CustomerIn customerIn;
    @Override
    public ResponseBase create(RequestCustomer request) {
        return customerIn.create(request);
    }

    @Override
    public ResponseBase update(Long code, RequestCustomer request) {
        return customerIn.update(code, request);
    }

    @Override
    public ResponseBase get(Long code) {
        return customerIn.get(code);
    }

    @Override
    public List<ResponseBase> getAll() {
        return customerIn.getAll();
    }
}
