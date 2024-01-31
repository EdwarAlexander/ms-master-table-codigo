package com.dev.ed.helper;

import com.dev.ed.domain.model.response.ResponseCapturesPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResponseCapturesPageHelper {

    public static ResponseCapturesPage createResponseCapturesPage(){
        ResponseCapturesPage response = new ResponseCapturesPage();
        response.setId(1L);
        response.setStatus(1);
        response.setDateCapture(LocalDate.of(2024,1,20));
        response.setObservation("observacion de prueba");
        response.setNameSeller("Vendedor 1");
        response.setNameCustomer("cliente 1");
        return response;
    }

    public static List<ResponseCapturesPage> createResponseCapturesPageList(){
        List<ResponseCapturesPage> lista = new ArrayList<>();
        lista.add(createResponseCapturesPage());
        return lista;
    }

    public static Page<ResponseCapturesPage> createResponseCapturesPagePage(){
        return new PageImpl<>(createResponseCapturesPageList());
    }
}
