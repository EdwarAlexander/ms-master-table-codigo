package com.dev.ed.application.controller;

import com.dev.ed.application.controller.api.ICustomerApi;
import com.dev.ed.application.service.CustomerService;
import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerApi {

    private final CustomerService customerService;
    @Override
    public ResponseEntity<ResponseBase<ResponseCustomer>> create(RequestCustomer requestCustomer) {
        ResponseBase<ResponseCustomer> responseBase = customerService.create(requestCustomer);
        return new ResponseEntity<>(responseBase, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCustomer>> update(Long id, RequestCustomer requestCustomer) {
        ResponseBase<ResponseCustomer> responseBase = customerService.update(id, requestCustomer);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<ResponseCustomer>> get(Long id) {
        ResponseBase<ResponseCustomer> responseBase = customerService.get(id);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBase<List<ResponseCustomer>>> getAll() {
        ResponseBase<List<ResponseCustomer>> responseBase = customerService.getAll();
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
