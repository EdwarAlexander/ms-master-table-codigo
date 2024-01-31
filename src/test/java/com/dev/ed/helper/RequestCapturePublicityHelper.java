package com.dev.ed.helper;

import com.dev.ed.domain.model.request.RequestCapturePublicity;

public class RequestCapturePublicityHelper {

    public static RequestCapturePublicity createRequestCapturePublicity(){
        RequestCapturePublicity request = new RequestCapturePublicity();
        request.setIdPublicity(1L);
        return request;
    }
}
