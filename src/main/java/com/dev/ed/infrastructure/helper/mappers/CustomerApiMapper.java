package com.dev.ed.infrastructure.helper.mappers;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.helper.response.ReniecResponseHelper;

public class CustomerApiMapper {

    private CustomerApiMapper(){

    }

    public static CustomerEntity mapToCustomerEntityApi(ReniecResponseHelper reniecResponseHelper){
        if(reniecResponseHelper == null){
            return null;
        }
        CustomerEntity entity = new CustomerEntity();
        entity.setName(reniecResponseHelper.getNombres());
        entity.setLastName(reniecResponseHelper.getApellidoPaterno()+' '+reniecResponseHelper.getApellidoMaterno());
        entity.setDocument(reniecResponseHelper.getNumeroDocumento());
        return entity;
    }
}
