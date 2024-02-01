package com.dev.ed.domain.model.response;

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
public class ResponseCaptures {

    private Long id;

    private LocalDate dateCapture;

    private ResponseCustomer responseCustomer;

    private ResponseSeller responseSeller;

    private String observation;

    private Integer status;

    private Set<ResponsePublicity> publicities;
}
