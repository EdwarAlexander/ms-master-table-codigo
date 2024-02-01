package com.dev.ed.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBase<T> {

    private String message;

    private T data;

    private ResponsePagination pagination;
}
