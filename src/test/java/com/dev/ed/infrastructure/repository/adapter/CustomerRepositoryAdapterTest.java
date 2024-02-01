package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.helper.CustomerEntityHelper;
import com.dev.ed.helper.RequestCustomerHelper;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class CustomerRepositoryAdapterTest {
    @InjectMocks
    private CustomerRepositoryAdapter customerRepositoryAdapter;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll(){
        Mockito.when(customerRepository.findAll()).thenReturn(new ArrayList<CustomerEntity>());
        ResponseBase<List<ResponseCustomer>> result = customerRepositoryAdapter.getAll();
        assertNotNull(result);
    }
    @Test
    void get(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        ResponseBase<ResponseCustomer> result = customerRepositoryAdapter.get(1L);
        assertNotNull(result);
    }

    @Test
    void get_Error(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            customerRepositoryAdapter.get(1L);
        });
        assertEquals("No existe el id en la tabla CLIENTE", exception.getMessage());
    }

    @Test
    void getAllPagination(){
        Mockito.when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(CustomerEntityHelper.createCustomerEntityPage());
        ResponseBase<List<ResponseCustomer>> result = customerRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
    }

    @Test
    void getAllPagination_EMPTY(){
        Mockito.when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<CustomerEntity>(new ArrayList<CustomerEntity>()));
        ResponseBase<List<ResponseCustomer>> result = customerRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
        assertTrue(result.getData().isEmpty());
    }
    @Test
    void update(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        ResponseBase<ResponseCustomer> result = customerRepositoryAdapter.update(1L, RequestCustomerHelper.createRequesCustomer());
        assertNotNull(result);
    }

    @Test
    void update_Error(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Exception exception = null;
        try{
            ResponseBase<ResponseCustomer> result = customerRepositoryAdapter.update(1L, RequestCustomerHelper.createRequesCustomer());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla CLIENTE", exception.getMessage());
    }

    @Test
    void create(){
        ResponseBase<ResponseCustomer> result = customerRepositoryAdapter.create(RequestCustomerHelper.createRequesCustomer());
        assertNotNull(result);
    }
}