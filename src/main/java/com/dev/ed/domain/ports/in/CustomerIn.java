package com.dev.ed.domain.ports.in;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.ports.crud.Crud;

public interface CustomerIn extends Crud<RequestCustomer, ResponseBase,Long> {
}
