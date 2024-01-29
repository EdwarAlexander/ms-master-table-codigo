package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/captacion")
public interface ICapturesApi {

    @PostMapping
    public ResponseEntity<ResponseBase<ResponseCaptures>> create(@RequestBody RequestCaptures requestCaptures) throws ParseException;
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> update(@PathVariable Long id, @RequestBody RequestCaptures requestCaptures);
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> get(@PathVariable Long id);
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAll();
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> delete(@PathVariable Long id);
    @GetMapping("/page")
    public ResponseEntity<ResponseBase<List<ResponseCapturesPage>>> getAllPage(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
}
