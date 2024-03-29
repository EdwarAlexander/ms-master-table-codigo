package com.dev.ed.infrastructure.util.mapper;

import com.dev.ed.domain.model.response.ResponsePagination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaginationMapper {

    PaginationMapper MAPPER = Mappers.getMapper(PaginationMapper.class);

    @Mapping(target = "currPage", source = "currPages")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "totalPages", source = "totalPages")
    ResponsePagination setPagination(Integer currPages, Integer totalElements, Integer totalPages);
}
