package com.dev.ed.application.usecase;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.domain.ports.in.PublicityIn;
import com.dev.ed.domain.ports.out.PublicityOut;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class PublicityServiceImpl implements PublicityIn {

    private final PublicityOut publicityOut;
    @Override
    public ResponseBase<ResponsePublicity> create(RequestPublicity request) {
        return publicityOut.create(request);
    }

    @Override
    public ResponseBase<ResponsePublicity> update(Long code, RequestPublicity request) {
        return publicityOut.update(code, request);
    }

    @Override
    public ResponseBase<ResponsePublicity> get(Long code) {
        return publicityOut.get(code);
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAll() {
        return publicityOut.getAll();
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAllPagination(Integer page, Integer limit, String sort) {
        return publicityOut.getAllPagination(page, limit, sort);
    }
}
