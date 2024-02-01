package com.dev.ed.domain.model.request;

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

    private LocalDate dateCapture;

    private Long customerId;

    private Long sellerId;

    private String observation;

    private Set<RequestCapturePublicity> publicities;

}
