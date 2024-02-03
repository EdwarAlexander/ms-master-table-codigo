package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes")
public interface ICustomerApi {

    @Operation(summary = "Metodo para registrar de cliente")
    @PostMapping
    public ResponseEntity<ResponseBase<ResponseCustomer>> create(@Valid @RequestBody RequestCustomer requestCustomer);
    @Operation(summary = "Metodo para actualizar de cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCustomer>> update(@Valid @PathVariable Long id, @RequestBody RequestCustomer requestCustomer);
    @Operation(summary = "Metodo para obtener un cliente por su codigo")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCustomer>> get(@PathVariable Long id);
    @Operation(summary = "Metodo para obtener todos los clientes")
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseCustomer>>> getAll();
    @Operation(summary = "Metodo para obtener todos los clientes paginados")
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseCustomer>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
    @Operation(summary = "Metodo para registrar de cliente mediante un api externa")
    @PostMapping("/api")
    public ResponseEntity<ResponseBase<ResponseCustomer>> createToApiClient(@RequestParam("document") String document);
    @Operation(summary = "Metodo para obtener un cliente utilizando redis")
    @GetMapping("/redis")
    public ResponseEntity<ResponseBase<ResponseCustomer>> getDocumentCustomer(@RequestParam("document") String document);
}
