package com.dev.ed.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomer {
    private Long id;
    private String name;
    private String lastName;
    private String telePhone;
    private String email;
    private String document;
}
