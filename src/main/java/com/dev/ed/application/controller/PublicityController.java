package com.dev.ed.application.controller;

import com.dev.ed.application.controller.api.IPublicityApi;
import com.dev.ed.application.service.PublicityService;
import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class PublicityController implements IPublicityApi {

    private final PublicityService publicityService;

    @Override
    public ResponseEntity<ResponseBase<ResponsePublicity>> create(RequestPublicity requestPublicity) {
        ResponseBase<ResponsePublicity> responseBase = publicityService.create(requestPublicity);
        return new ResponseEntity<>(responseBase, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponsePublicity>> update(Long id, RequestPublicity requestPublicity) {
        ResponseBase<ResponsePublicity> responseBase = publicityService.update(id, requestPublicity);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponsePublicity>> get(Long id) {
        ResponseBase<ResponsePublicity> responseBase = publicityService.get(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAll() {
        ResponseBase<List<ResponsePublicity>> responseBase = publicityService.getAll();
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponsePublicity>> responseBase = publicityService.getAllPagination(page != null ? page : ConstantUtil.DEFAULT_PAGE, limit != null ? limit : ConstantUtil.DEFAULT_LIMIT, sort != null ? sort.toLowerCase() : ConstantUtil.DEFAULT_ASCENDING_VALUE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
