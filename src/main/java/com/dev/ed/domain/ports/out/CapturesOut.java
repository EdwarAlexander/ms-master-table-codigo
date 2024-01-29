package com.dev.ed.domain.ports.out;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.domain.ports.crud.Crud;

import java.util.List;

public interface CapturesOut extends Crud<RequestCaptures, ResponseCaptures, Long> {
    ResponseBase<List<ResponseCapturesPage>> getCapturePage(Integer page, Integer limit, String sort);
}
