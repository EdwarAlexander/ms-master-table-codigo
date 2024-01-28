package com.dev.ed.infrastructure.helper.mappers;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.infrastructure.entity.CapturesEntity;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.util.common.DateUtil;

import java.text.ParseException;

public class CapturesMapper {

    public static CapturesEntity mapToCaptureEntity(RequestCaptures requestCaptures, CustomerEntity customerEntity, SellersEntity sellersEntity) {
        if(requestCaptures == null){
            return null;
        }
        CapturesEntity capturesEntity = new CapturesEntity();
        capturesEntity.setDateCapture(requestCaptures.getDateCapture());
        capturesEntity.setObservation(requestCaptures.getObservation());
        capturesEntity.setCustomerEntity(customerEntity);
        capturesEntity.setSellersEntity(sellersEntity);
        return capturesEntity;
    }

    public static ResponseCaptures mapToResponseCaptures(CapturesEntity capturesEntity){
        if(capturesEntity == null){
            return null;
        }
        ResponseCaptures responseCaptures = new ResponseCaptures();

        responseCaptures.setId(capturesEntity.getId());
        responseCaptures.setDateCapture(capturesEntity.getDateCapture());
        responseCaptures.setObservation(capturesEntity.getObservation());
        responseCaptures.setResponseCustomer(setResponseCustomer(capturesEntity.getCustomerEntity()));
        responseCaptures.setResponseSeller(setResponseSeller(capturesEntity.getSellersEntity()));

        return responseCaptures;
    }

    private static ResponseCustomer setResponseCustomer(CustomerEntity customerEntity){
        if(customerEntity == null){
            return null;
        }
        ResponseCustomer responseCustomer = new ResponseCustomer();
        responseCustomer.setId(customerEntity.getId());
        responseCustomer.setName(customerEntity.getName());
        responseCustomer.setEmail(customerEntity.getEmail());
        responseCustomer.setDocument(customerEntity.getDocument());
        responseCustomer.setTelePhone(customerEntity.getTelePhone());
        responseCustomer.setLastName(customerEntity.getLastName());

        return responseCustomer;
    }

    private static ResponseSeller setResponseSeller(SellersEntity sellersEntity){
        if(sellersEntity == null){
            return null;
        }

        ResponseSeller responseSeller = new ResponseSeller();

        responseSeller.setId(sellersEntity.getId());
        responseSeller.setStatus(sellersEntity.getStatus());
        responseSeller.setName(sellersEntity.getName());
        responseSeller.setEmail(sellersEntity.getEmail());

        return responseSeller;
    }
}
