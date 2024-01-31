package com.dev.ed.helper;

import com.dev.ed.infrastructure.entity.CapturesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class CaptureEntityHelper {

    public static CapturesEntity createCapturesEntity(){
        CapturesEntity entity = new CapturesEntity();
        entity.setId(1L);
        entity.setObservation("observacion");
        return entity;
    }

    public static List<CapturesEntity> createCapturesEntityList(){
        List<CapturesEntity> lista = new ArrayList<>();
        lista.add(createCapturesEntity());
        return lista;
    }

    public static Page<CapturesEntity> createCapturesEntityPage(){
        return new PageImpl<>(createCapturesEntityList());
    }
}
