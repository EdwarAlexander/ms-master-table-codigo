package com.dev.ed.domain.ports.in;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.ports.crud.Crud;

public interface CapturesIn extends Crud<RequestCaptures, ResponseCaptures, Long> {
}
