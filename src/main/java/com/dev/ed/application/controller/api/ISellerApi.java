package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
public interface ISellerApi {

    @PostMapping
    public ResponseEntity<ResponseBase<ResponseSeller>> create(@RequestBody RequestSeller requestSeller);
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> update(@PathVariable Long id, @RequestBody RequestSeller requestSeller);
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> get(@PathVariable Long id);
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAll();
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> delete(@PathVariable Long id);
}
