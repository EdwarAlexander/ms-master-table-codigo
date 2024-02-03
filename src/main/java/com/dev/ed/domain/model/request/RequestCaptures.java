package com.dev.ed.domain.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCaptures {

    @NotEmpty(message = "Debes ingresar el fecha")
    @NotNull(message = "No debe ser nulo el campo date")
    private LocalDate dateCapture;

    @NotEmpty(message = "Debes ingresar el codigo del cliente")
    @NotNull(message = "No debe ser nulo el campo customerId")
    private Long customerId;

    @NotEmpty(message = "Debes ingresar el codigo del vendedor")
    @NotNull(message = "No debe ser nulo el campo sellerId")
    private Long sellerId;

    private String observation;

    @NotNull(message = "No debe ser nulo el listado de publicidades")
    private Set<RequestCapturePublicity> publicities;

}
