package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
@Tag(name = "Vendedor")
public interface ISellerApi {
    @Operation(summary = "Metodo para registrar un vendedor")
    @PostMapping
    public ResponseEntity<ResponseBase<ResponseSeller>> create(@Valid @RequestBody RequestSeller requestSeller);
    @Operation(summary = "Metodo para actualizar un vendedor")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> update(@Valid @PathVariable Long id, @RequestBody RequestSeller requestSeller);
    @Operation(summary = "Metodo para obtener un vendedor")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> get(@PathVariable Long id);
    @Operation(summary = "Metodo para mostrar todos los vendedores")
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAll();
    @Operation(summary = "Metodo para mostrar todos los vendedores paginados")
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseSeller>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
    @Operation(summary = "Metodo para eliminar un vendedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseSeller>> delete(@PathVariable Long id);
}
