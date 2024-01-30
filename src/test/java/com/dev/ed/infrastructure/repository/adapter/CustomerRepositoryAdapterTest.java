package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


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

}