package com.dev.ed.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

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
}
