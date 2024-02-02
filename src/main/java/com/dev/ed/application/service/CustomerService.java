package com.dev.ed.application.service;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.ports.in.CustomerIn;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class CustomerService implements CustomerIn {

    private final CustomerIn customerIn;


    @Override
    public ResponseBase<ResponseCustomer> create(RequestCustomer request) {
        return customerIn.create(request);
    }

    @Override
    public ResponseBase<ResponseCustomer> update(Long code, RequestCustomer request) {
        return customerIn.update(code, request);
    }

    @Override
    public ResponseBase<ResponseCustomer> get(Long code) {
        return customerIn.get(code);
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAll() {
        return customerIn.getAll();
    }

    @Override
    public ResponseBase<List<ResponseCustomer>> getAllPagination(Integer page, Integer limit, String sort) {
        return customerIn.getAllPagination(page, limit, sort);
    }

    @Override
    public ResponseBase<ResponseCustomer> createToApiClient(String document) {
        return customerIn.createToApiClient(document);
    }
}
