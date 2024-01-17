package com.dev.ed.infrastructure.util.mapper;

import com.dev.ed.domain.model.request.RequestCustomer;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity mapToCustomerEntity(RequestCustomer requestCustomer);

    ResponseCustomer mapToResponseCustomer(CustomerEntity customerEntity);
    @Mapping(source = "requestCustomer.document", target = "document")
    @Mapping(source = "requestCustomer.email", target = "email")
    @Mapping(source = "requestCustomer.lastName", target = "lastName")
    @Mapping(source = "requestCustomer.name", target = "name")
    @Mapping(source = "requestCustomer.telePhone", target = "telePhone")
    CustomerEntity mapRequestToEntity(RequestCustomer requestCustomer, CustomerEntity entity);

    List<ResponseCustomer> mapToResponseCustomerList(List<CustomerEntity> customerEntityList);
}
