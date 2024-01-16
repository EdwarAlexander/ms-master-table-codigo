package com.dev.ed.application.usecase;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.in.CustomerIn;
import com.dev.ed.domain.ports.out.CustomerOut;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerIn {
    private final CustomerOut customerOut;

    @Override
    public ResponseCustomer create(RequestCustomer request) {
        return customerOut.create(request);
    }

    @Override
    public Optional<ResponseCustomer> update(Long code, RequestCustomer request) {
        return customerOut.update(code, request);
    }

    @Override
    public Optional<ResponseCustomer> get(Long code) {
        return customerOut.get(code);
    }

    @Override
    public List<ResponseCustomer> getAll() {
        return customerOut.getAll();
    }
}
