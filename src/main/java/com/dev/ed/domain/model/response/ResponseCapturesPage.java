package com.dev.ed.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCapturesPage {

    private Long id;

    private LocalDate dateCapture;

    private String nameCustomer;

    private String nameSeller;

    private Integer status;

    private String observation;
}
