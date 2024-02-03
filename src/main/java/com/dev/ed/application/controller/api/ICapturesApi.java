package com.dev.ed.application.controller.api;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/captacion")
@Tag(name = "Captación de clientes")
public interface ICapturesApi {

    @Operation(summary = "Metodo para registrar una captación de cliente")
    @PostMapping
    public ResponseEntity<ResponseBase<ResponseCaptures>> create(@Valid @RequestBody RequestCaptures requestCaptures) throws ParseException;
    @Operation(summary = "Metodo para actualizar una captación de cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> update(@Valid @PathVariable Long id, @RequestBody RequestCaptures requestCaptures);
    @Operation(summary = "Metodo para obtener una captación por su codigo")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> get(@PathVariable Long id);
    @Operation(summary = "Metodo para obtener todas las captación")
    @GetMapping
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAll();
    @Operation(summary = "Metodo para obtener todas las captación paginadas")
    @GetMapping("/pagination")
    public ResponseEntity<ResponseBase<List<ResponseCaptures>>> getAllPagination(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
    @Operation(summary = "Metodo para eliminar una captación")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseCaptures>> delete(@PathVariable Long id);
    @Operation(summary = "Metodo para obtener todas las captación paginadas - OK")
    @GetMapping("/page")
    public ResponseEntity<ResponseBase<List<ResponseCapturesPage>>> getAllPage(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "sort", required = false) String sort);
}
