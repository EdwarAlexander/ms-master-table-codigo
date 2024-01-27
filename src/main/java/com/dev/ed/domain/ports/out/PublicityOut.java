package com.dev.ed.domain.ports.out;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.domain.ports.crud.Crud;

public interface PublicityOut extends Crud<RequestPublicity, ResponsePublicity, Long> {
}
