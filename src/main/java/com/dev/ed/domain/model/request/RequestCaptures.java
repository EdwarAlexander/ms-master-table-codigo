package com.dev.ed.domain.model.request;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.SellersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCaptures {

    private LocalDate dateCapture;

    private Long customer_id;

    private Long seller_id;

    private String observation;

    private Set<RequestCapturePublicity> publicities;

}
