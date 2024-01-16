package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public interface ICustomerApi {

    @PostMapping
    public ResponseEntity<ResponseCustomer> create(@RequestBody RequestCustomer requestCustomer);
}
