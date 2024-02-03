package com.dev.ed.domain.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResponsePagination pagination;
}
