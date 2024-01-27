package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.model.response.ResponsePublicity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicidad")
public interface IPublicityApi {

    @PostMapping
    public ResponseEntity<ResponseBase<ResponsePublicity>> create(@RequestBody RequestPublicity requestPublicity);
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponsePublicity>> update(@PathVariable Long id, @RequestBody RequestPublicity requestPublicity);
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponsePublicity>> get(@PathVariable Long id);
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAll();
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
}
