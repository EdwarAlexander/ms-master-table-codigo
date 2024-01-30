package com.dev.ed.application.service;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.domain.ports.in.CapturesIn;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class CapturesService implements CapturesIn {

    private final CapturesIn capturesIn;

    @Override
    public ResponseBase<ResponseCaptures> create(RequestCaptures request) {
        return capturesIn.create(request);
    }

    @Override
    public ResponseBase<ResponseCaptures> update(Long code, RequestCaptures request) {
        return capturesIn.update(code, request);
    }

    @Override
    public ResponseBase<ResponseCaptures> get(Long code) {
        return capturesIn.get(code);
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAll() {
        return capturesIn.getAll();
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAllPagination(Integer page, Integer limit, String sort) {
        return capturesIn.getAllPagination(page, limit, sort);
    }

    @Override
    public ResponseBase<List<ResponseCapturesPage>> getCapturePage(Integer page, Integer limit, String sort) {
        return capturesIn.getCapturePage(page, limit, sort);
    }

    @Override
    public ResponseBase<ResponseCaptures> delete(Long id) {
        return capturesIn.delete(id);
    }
}
