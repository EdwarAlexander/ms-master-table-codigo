package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponsePublicity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicidad")
@Tag(name = "Publicidad")
public interface IPublicityApi {
    @Operation(summary = "Metodo para registrar una publicidad")
    @PostMapping
    public ResponseEntity<ResponseBase<ResponsePublicity>> create(@Valid @RequestBody RequestPublicity requestPublicity);
    @Operation(summary = "Metodo para actualizar una publicidad")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponsePublicity>> update(@PathVariable Long id, @RequestBody RequestPublicity requestPublicity);
    @Operation(summary = "Metodo para obtener una publicidad")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponsePublicity>> get(@PathVariable Long id);
    @Operation(summary = "Metodo para mostrar todas las publicidades")
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAll();
    @Operation(summary = "Metodo para mostrar todas las publicidades paginadas")
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponsePublicity>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
}
