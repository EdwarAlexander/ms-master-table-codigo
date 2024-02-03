package com.dev.ed.domain.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPublicity {

    @NotEmpty(message = "Debes ingresar el Nombre de la Publicidad")
    private String name;
}
