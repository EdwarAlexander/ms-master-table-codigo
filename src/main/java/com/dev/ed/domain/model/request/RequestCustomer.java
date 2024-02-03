package com.dev.ed.domain.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomer {
    @NotEmpty(message = "Debes ingresar el Nombre ")
    @NotNull(message = "No debe ser nulo el campo name")
    private String name;

    @NotEmpty(message = "Debes ingresar los apellidos")
    @NotNull(message = "No debe ser nulo el campo lastname")
    private String lastName;

    @NotEmpty(message = "Debes ingresar el telefono")
    @NotNull(message = "No debe ser nulo el campo telephone")
    private String telePhone;

    @NotEmpty(message = "Debes ingresar el email")
    @Email
    @NotNull(message = "No debe ser nulo el campo email")
    private String email;

    @NotEmpty(message = "Debes ingresar el documento")
    @NotNull(message = "No debe ser nulo el campo document")
    private String document;
}
