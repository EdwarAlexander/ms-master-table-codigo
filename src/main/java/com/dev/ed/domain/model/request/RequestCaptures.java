package com.dev.ed.domain.model.request;

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

    @NotNull(message = "No debe ser nulo el campo date")
    private LocalDate dateCapture;

    @NotNull(message = "No debe ser nulo el campo customerId")
    private Long customerId;

    @NotNull(message = "No debe ser nulo el campo sellerId")
    private Long sellerId;

    private String observation;

    @NotNull(message = "No debe ser nulo el listado de publicidades")
    private Set<RequestCapturePublicity> publicities;

}
