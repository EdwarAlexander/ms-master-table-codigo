package com.dev.ed.application.service;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.domain.ports.in.SellerIn;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class SellerService implements SellerIn {

    private final SellerIn sellerIn;

    @Override
    public ResponseBase<ResponseSeller> create(RequestSeller request) {
        return sellerIn.create(request);
    }

    @Override
    public ResponseBase<ResponseSeller> update(Long code, RequestSeller request) {
        return sellerIn.update(code, request);
    }

    @Override
    public ResponseBase<ResponseSeller> get(Long code) {
        return sellerIn.get(code);
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAll() {
        return sellerIn.getAll();
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAllPagination(Integer page, Integer limit, String sort) {
        return sellerIn.getAllPagination(page, limit, sort);
    }

    @Override
    public ResponseBase<ResponseSeller> delete(Long id) {
        return sellerIn.delete(id);
    }
}
