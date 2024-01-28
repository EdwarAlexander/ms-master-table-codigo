package com.dev.ed.application.controller;

import com.dev.ed.application.controller.api.ICapturesApi;
import com.dev.ed.application.service.CapturesService;
import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CapturesController implements ICapturesApi {

    private final CapturesService capturesService;

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> create(RequestCaptures requestCaptures) {
        ResponseBase<ResponseCaptures> responseBase = capturesService.create(requestCaptures);
        return new ResponseEntity<>(responseBase, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> update(Long id, RequestCaptures requestCaptures) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAllPagination(Integer page, Integer limit, String sort) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> delete(Long id) {
        return null;
    }
}
