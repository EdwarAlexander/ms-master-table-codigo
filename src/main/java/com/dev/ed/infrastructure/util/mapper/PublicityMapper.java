package com.dev.ed.infrastructure.util.mapper;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.infrastructure.entity.PublicityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublicityMapper {
    PublicityMapper MAPPER = Mappers.getMapper(PublicityMapper.class);

    PublicityEntity mapToPublicityEntity(RequestPublicity requestPublicity);

    ResponsePublicity mapToResponsePublicity(PublicityEntity publicityEntity);
    @Mapping(source = "requestPublicity.name", target = "name")
    PublicityEntity mapRequestToEntity(RequestPublicity requestPublicity, PublicityEntity publicityEntity);

    List<ResponsePublicity> setResponsePublicityList(List<PublicityEntity> publicityEntityList);
}
