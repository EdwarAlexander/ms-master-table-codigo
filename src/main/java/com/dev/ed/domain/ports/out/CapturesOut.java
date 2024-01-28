package com.dev.ed.domain.ports.out;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.ports.crud.Crud;

public interface CapturesOut extends Crud<RequestCaptures, ResponseCaptures, Long> {
}
