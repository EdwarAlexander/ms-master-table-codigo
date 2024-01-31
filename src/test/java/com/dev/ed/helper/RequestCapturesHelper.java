package com.dev.ed.helper;

import com.dev.ed.domain.model.request.RequestCapturePublicity;
import com.dev.ed.domain.model.request.RequestCaptures;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class RequestCapturesHelper {

    public static RequestCaptures createRequestCaptures(){
        RequestCaptures request = new RequestCaptures();
        request.setCustomer_id(1L);
        request.setSeller_id(1L);
        request.setDateCapture(LocalDate.of(2024,1,20));
        request.setPublicities(createRequestPublicitySet());
        return request;
    }

    public static Set<RequestCapturePublicity> createRequestPublicitySet(){
        Set<RequestCapturePublicity> requestPublicitySet = new HashSet<>();
        requestPublicitySet.add(RequestCapturePublicityHelper.createRequestCapturePublicity());
        return requestPublicitySet;
    }
}
