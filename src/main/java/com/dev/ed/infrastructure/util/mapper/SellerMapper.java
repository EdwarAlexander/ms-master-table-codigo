package com.dev.ed.infrastructure.util.mapper;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.infrastructure.entity.SellersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SellerMapper {

    SellerMapper MAPPER = Mappers.getMapper(SellerMapper.class);

    SellersEntity mapToSellersEntity(RequestSeller requestSeller);

    ResponseSeller mapToResponseSeller(SellersEntity sellersEntity);
    @Mapping(source = "requestSeller.name", target = "name")
    @Mapping(source = "requestSeller.email", target = "email")
    SellersEntity mapRequestToEntity(RequestSeller requestSeller, SellersEntity sellersEntity);
    List<ResponseSeller> setResponseSellerList(List<SellersEntity> sellersEntityList);
}
