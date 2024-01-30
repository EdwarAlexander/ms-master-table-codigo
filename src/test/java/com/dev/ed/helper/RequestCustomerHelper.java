package com.dev.ed.helper;

import com.dev.ed.domain.model.request.RequestCustomer;

public class RequestCustomerHelper {

    public static RequestCustomer createRequesCustomer(){
        RequestCustomer request = new RequestCustomer();
        request.setName("cliente de prueba");
        request.setDocument("78965412");
        request.setEmail("dfg@gmail.com");
        request.setLastName("cliente de prueba");
        request.setTelePhone("78964123");
        return request;
    }
}
