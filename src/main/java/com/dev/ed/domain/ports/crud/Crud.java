package com.dev.ed.domain.ports.crud;

import com.dev.ed.domain.model.response.ResponseBase;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface Crud <RQ,RS,ID>{
    ResponseBase<RS> create(RQ request);
    ResponseBase<RS> update(ID code, RQ request);
    ResponseBase<RS> get(ID code);
    ResponseBase<List<RS>> getAll();
    ResponseBase<List<RS>> getAllPagination(Integer page, Integer limit, String sort);
}
