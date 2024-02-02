package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public interface ICustomerApi {

    @PostMapping
    public ResponseEntity<ResponseBase<ResponseCustomer>> create(@RequestBody RequestCustomer requestCustomer);

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCustomer>> update(@PathVariable Long id, @RequestBody RequestCustomer requestCustomer);
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCustomer>> get(@PathVariable Long id);
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseCustomer>>> getAll();

    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseCustomer>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);

    @PostMapping("/api")
    public ResponseEntity<ResponseBase<ResponseCustomer>> createToApiClient(@RequestParam("document") String document);
}
