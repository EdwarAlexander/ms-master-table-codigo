package com.dev.ed.domain.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomer {
    private String name;
    private String lastName;
    private String telePhone;
    private String email;
    private String document;
}
