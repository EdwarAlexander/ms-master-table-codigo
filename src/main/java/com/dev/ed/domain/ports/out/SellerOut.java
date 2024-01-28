package com.dev.ed.domain.ports.out;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.domain.ports.crud.Crud;

public interface SellerOut extends Crud<RequestSeller, ResponseSeller, Long> {

    ResponseBase<ResponseSeller> delete(Long id);
}
