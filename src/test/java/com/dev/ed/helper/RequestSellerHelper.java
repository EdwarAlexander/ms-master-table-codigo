package com.dev.ed.helper;

import com.dev.ed.domain.model.request.RequestSeller;

public class RequestSellerHelper {

    public static RequestSeller createRequestSeller(){
        RequestSeller request = new RequestSeller();
        request.setEmail("dfg@hotmail.com");
        request.setName("vendedor 1");
        return request;
    }
}
