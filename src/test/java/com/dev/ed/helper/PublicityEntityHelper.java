package com.dev.ed.helper;

import com.dev.ed.infrastructure.entity.PublicityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class PublicityEntityHelper {

    public static PublicityEntity createPublicityEntity(){
        PublicityEntity entity = new PublicityEntity();
        entity.setId(1L);
        entity.setStatus(1);
        entity.setName("Facebook");
        return entity;
    }

    public static List<PublicityEntity> createPublicityEntityList(){
        List<PublicityEntity> lista = new ArrayList<>();
        lista.add(createPublicityEntity());
        return lista;
    }

    public static Page<PublicityEntity> createPublicityEntityPage(){
        return new PageImpl<>(createPublicityEntityList());
    }
}
