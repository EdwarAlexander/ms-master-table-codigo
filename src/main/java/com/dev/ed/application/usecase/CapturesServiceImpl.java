package com.dev.ed.application.usecase;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.ports.in.CapturesIn;
import com.dev.ed.domain.ports.out.CapturesOut;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class CapturesServiceImpl implements CapturesIn {

    private final CapturesOut capturesOut;

    @Override
    public ResponseBase<ResponseCaptures> create(RequestCaptures request) {
        return capturesOut.create(request);
    }

    @Override
    public ResponseBase<ResponseCaptures> update(Long code, RequestCaptures request) {
        return capturesOut.update(code, request);
    }

    @Override
    public ResponseBase<ResponseCaptures> get(Long code) {
        return capturesOut.get(code);
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAll() {
        return capturesOut.getAll();
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAllPagination(Integer page, Integer limit, String sort) {
        return capturesOut.getAllPagination(page, limit, sort);
    }
}
