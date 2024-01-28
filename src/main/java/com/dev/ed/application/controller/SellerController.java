package com.dev.ed.application.controller;

import com.dev.ed.application.controller.api.ISellerApi;
import com.dev.ed.application.service.SellerService;
import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SellerController implements ISellerApi {

    private final SellerService sellerService;

    @Override
    public ResponseEntity<ResponseBase<ResponseSeller>> create(RequestSeller requestSeller) {
        ResponseBase<ResponseSeller> responseBase = sellerService.create(requestSeller);
        return new ResponseEntity<>(responseBase, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseSeller>> update(Long id, RequestSeller requestSeller) {
        ResponseBase<ResponseSeller> responseBase = sellerService.update(id, requestSeller);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseSeller>> get(Long id) {
        ResponseBase<ResponseSeller> responseBase = sellerService.get(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAll() {
        ResponseBase<List<ResponseSeller>> responseBase = sellerService.getAll();
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseSeller>> responseBase = sellerService.getAllPagination(page != null ? page : ConstantUtil.DEFAULT_PAGE, limit != null ? limit : ConstantUtil.DEFAULT_LIMIT, sort != null ? sort.toLowerCase() : ConstantUtil.DEFAULT_ASCENDING_VALUE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseSeller>> delete(Long id) {
        ResponseBase<ResponseSeller> responseBase = sellerService.delete(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
