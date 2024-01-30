package com.dev.ed.helper;

import com.dev.ed.domain.model.request.RequestPublicity;

public class RequestPublicityHelper {

    public static RequestPublicity createRequestPublicity(){
        RequestPublicity request = new RequestPublicity();
        request.setName("Instagram");
        return request;
    }
}
