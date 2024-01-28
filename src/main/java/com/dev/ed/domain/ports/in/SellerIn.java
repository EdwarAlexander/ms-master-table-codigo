package com.dev.ed.domain.ports.in;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.domain.ports.crud.Crud;

public interface SellerIn extends Crud<RequestSeller, ResponseSeller, Long> {

    ResponseBase<ResponseSeller> delete(Long id);
}
