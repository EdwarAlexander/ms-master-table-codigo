package com.dev.ed.helper;

import com.dev.ed.infrastructure.entity.SellersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class SellerEntityHelper {

    public static SellersEntity createSellersEntity(){
        SellersEntity entity = new SellersEntity();
        entity.setId(1L);
        entity.setStatus(1);
        entity.setEmail("drftg@hotmail.com");
        entity.setName("vendedor 1");
        return entity;
    }

    public static List<SellersEntity> createSellersEntityList(){
        List<SellersEntity> lista = new ArrayList<>();
        lista.add(createSellersEntity());
        return lista;
    }

    public static Page<SellersEntity> createSellersEntityPage(){
        return new PageImpl<SellersEntity>(createSellersEntityList());
    }
}
