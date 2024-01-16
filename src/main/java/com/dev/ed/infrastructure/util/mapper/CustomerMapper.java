package com.dev.ed.infrastructure.util.mapper;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity mapToCustomerEntity(RequestCustomer requestCustomer);

    ResponseCustomer mapToResponseCustomer(CustomerEntity customerEntity);
}
