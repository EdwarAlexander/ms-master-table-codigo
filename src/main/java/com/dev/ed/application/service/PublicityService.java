package com.dev.ed.application.service;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.domain.ports.in.PublicityIn;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class PublicityService implements PublicityIn {

    private final PublicityIn publicityIn;

    @Override
    public ResponseBase<ResponsePublicity> create(RequestPublicity request) {
        return publicityIn.create(request);
    }

    @Override
    public ResponseBase<ResponsePublicity> update(Long code, RequestPublicity request) {
        return publicityIn.update(code, request);
    }

    @Override
    public ResponseBase<ResponsePublicity> get(Long code) {
        return publicityIn.get(code);
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAll() {
        return publicityIn.getAll();
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAllPagination(Integer page, Integer limit, String sort) {
        return publicityIn.getAllPagination(page, limit, sort);
    }
}
