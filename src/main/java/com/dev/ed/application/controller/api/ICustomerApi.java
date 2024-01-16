package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public interface ICustomerApi {

    @PostMapping
    public ResponseEntity<ResponseBase> create(@RequestBody RequestCustomer requestCustomer);

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase> update(@PathVariable Long id, @RequestBody RequestCustomer requestCustomer);
}
