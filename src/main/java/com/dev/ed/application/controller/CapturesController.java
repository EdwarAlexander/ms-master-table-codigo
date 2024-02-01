package com.dev.ed.application.controller;

import com.dev.ed.application.controller.api.ICapturesApi;
import com.dev.ed.application.service.CapturesService;
import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
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
        ResponseBase<ResponseCaptures> responseBase = capturesService.update(id, requestCaptures);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> get(Long id) {
        ResponseBase<ResponseCaptures> responseBase = capturesService.get(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAll() {
        ResponseBase<List<ResponseCaptures>> responseBase = capturesService.getAll();
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseCaptures>> responseBase = capturesService.getAllPagination(page != null ? page : ConstantUtil.DEFAULT_PAGE, limit != null ? limit : ConstantUtil.DEFAULT_LIMIT, sort != null ? sort.toLowerCase() : ConstantUtil.DEFAULT_ASCENDING_VALUE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCaptures>> delete(Long id) {
        ResponseBase<ResponseCaptures> responseBase = capturesService.delete(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCapturesPage>>> getAllPage(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseCapturesPage>> responseBase = capturesService.getCapturePage(page != null ? page : ConstantUtil.DEFAULT_PAGE, limit != null ? limit : ConstantUtil.DEFAULT_LIMIT, sort != null ? sort.toLowerCase() : ConstantUtil.DEFAULT_DESCENDING_VALUE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
