package com.dev.ed.helper;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerEntityHelper {

    public static CustomerEntity createCustomerEntity(){
        CustomerEntity entity = new CustomerEntity();
        entity.setId(1L);
        entity.setName("cliente de prueba");
        return entity;
    }

    public static List<CustomerEntity> createCustomerEntityList(){
        List<CustomerEntity> lista = new ArrayList<>();
        lista.add(createCustomerEntity());
        return lista;
    }

    public static Page<CustomerEntity> createCustomerEntityPage(){
        return new PageImpl<CustomerEntity>(createCustomerEntityList());
    }
}
