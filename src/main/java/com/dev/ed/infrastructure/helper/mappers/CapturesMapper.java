package com.dev.ed.infrastructure.helper.mappers;

import com.dev.ed.domain.model.request.RequestCapturePublicity;
import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.infrastructure.entity.CapturesEntity;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.PublicityEntity;
import com.dev.ed.infrastructure.entity.SellersEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        capturesEntity.setPublicityEntitySet(setPublicityEntitySet(requestCaptures.getPublicities()));
        return capturesEntity;
    }

    public static CapturesEntity mapToCaptureEntityUpdated(RequestCaptures requestCaptures, CustomerEntity customerEntity, SellersEntity sellersEntity, CapturesEntity captures) {
        if(requestCaptures == null){
            return null;
        }
        CapturesEntity capturesEntity = new CapturesEntity();

        capturesEntity.setId(captures.getId());
        capturesEntity.setStatus(captures.getStatus());
        capturesEntity.setDateCreate(captures.getDateCreate());
        capturesEntity.setUserCreate(captures.getUserCreate());

        capturesEntity.setDateCapture(requestCaptures.getDateCapture());
        capturesEntity.setObservation(requestCaptures.getObservation());
        capturesEntity.setCustomerEntity(customerEntity);
        capturesEntity.setSellersEntity(sellersEntity);
        capturesEntity.setPublicityEntitySet(setPublicityEntitySet(requestCaptures.getPublicities()));
        return capturesEntity;
    }

    public static CapturesEntity mapToCaptureEntityDelete(CapturesEntity captures) {
        if(captures == null){
            return null;
        }
        CapturesEntity capturesEntity = new CapturesEntity();

        capturesEntity.setId(captures.getId());
        capturesEntity.setDateCreate(captures.getDateCreate());
        capturesEntity.setUserCreate(captures.getUserCreate());
        capturesEntity.setDateModif(captures.getDateModif());
        capturesEntity.setUserModif(captures.getUserModif());

        capturesEntity.setDateCapture(captures.getDateCapture());
        capturesEntity.setObservation(captures.getObservation());
        capturesEntity.setCustomerEntity(captures.getCustomerEntity());
        capturesEntity.setSellersEntity(captures.getSellersEntity());
        capturesEntity.setPublicityEntitySet(captures.getPublicityEntitySet());
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
        responseCaptures.setStatus(capturesEntity.getStatus());
        responseCaptures.setResponseCustomer(setResponseCustomer(capturesEntity.getCustomerEntity()));
        responseCaptures.setResponseSeller(setResponseSeller(capturesEntity.getSellersEntity()));
        responseCaptures.setPublicities(setResponsePublicitySet(capturesEntity.getPublicityEntitySet()));
        return responseCaptures;
    }

    public static List<ResponseCaptures> mapToResponseCapturesList(List<CapturesEntity> capturesEntityList){
        if(capturesEntityList == null){
            return null;
        }
        List<ResponseCaptures> responseCapturesList = new ArrayList<>();
        for(CapturesEntity captures: capturesEntityList){
            responseCapturesList.add(mapToResponseCaptures(captures));
        }
        return responseCapturesList;
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

    private static PublicityEntity setPublicityEntity(RequestCapturePublicity requestCapturePublicity){
        if(requestCapturePublicity == null){
            return null;
        }
        PublicityEntity entity = new PublicityEntity();
        entity.setId(requestCapturePublicity.getIdPublicity());
        return entity;
    }

    private static Set<PublicityEntity> setPublicityEntitySet(Set<RequestCapturePublicity> requestCapturePublicitySet){
        Set<PublicityEntity> entitySet = new HashSet<>();
        for(RequestCapturePublicity requestCapturePublicity : requestCapturePublicitySet){
            entitySet.add(setPublicityEntity(requestCapturePublicity));
        }
        return entitySet;
    }

    private static ResponsePublicity setResponsePublicity(PublicityEntity publicityEntity){
        if(publicityEntity == null){
            return null;
        }
        ResponsePublicity responsePublicity = new ResponsePublicity();
        responsePublicity.setId(publicityEntity.getId());
        responsePublicity.setName(publicityEntity.getName());
        responsePublicity.setStatus(publicityEntity.getStatus());
        return responsePublicity;
    }
    private static Set<ResponsePublicity> setResponsePublicitySet(Set<PublicityEntity> publicityEntitySet){
        Set<ResponsePublicity> entitySet = new HashSet<>();
        for(PublicityEntity publicityEntity: publicityEntitySet){
            entitySet.add(setResponsePublicity(publicityEntity));
        }
        return entitySet;
    }
}
