package com.dev.ed.application.usecase;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.domain.ports.in.SellerIn;
import com.dev.ed.domain.ports.out.SellerOut;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class SellerServiceImpl implements SellerIn {

    private final SellerOut sellerOut;

    @Override
    public ResponseBase<ResponseSeller> create(RequestSeller request) {
        return sellerOut.create(request);
    }

    @Override
    public ResponseBase<ResponseSeller> update(Long code, RequestSeller request) {
        return sellerOut.update(code, request);
    }

    @Override
    public ResponseBase<ResponseSeller> get(Long code) {
        return sellerOut.get(code);
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAll() {
        return sellerOut.getAll();
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAllPagination(Integer page, Integer limit, String sort) {
        return sellerOut.getAllPagination(page, limit, sort);
    }

    @Override
    public ResponseBase<ResponseSeller> delete(Long id) {
        return sellerOut.delete(id);
    }
}
