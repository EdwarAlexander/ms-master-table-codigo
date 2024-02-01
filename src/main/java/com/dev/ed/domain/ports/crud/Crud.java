package com.dev.ed.domain.ports.crud;

import com.dev.ed.domain.model.response.ResponseBase;


import java.util.List;

public interface Crud <R,S,T>{
    ResponseBase<S> create(R request);
    ResponseBase<S> update(T code, R request);
    ResponseBase<S> get(T code);
    ResponseBase<List<S>> getAll();
    ResponseBase<List<S>> getAllPagination(Integer page, Integer limit, String sort);
}
