package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.helper.CustomerEntityHelper;
import com.dev.ed.helper.PublicityEntityHelper;
import com.dev.ed.helper.RequestCustomerHelper;
import com.dev.ed.helper.RequestPublicityHelper;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.PublicityEntity;
import com.dev.ed.infrastructure.repository.PublicityRepository;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublicityRepositoryAdapterTest {
    @InjectMocks
    private PublicityRepositoryAdapter publicityRepositoryAdapter;
    @Mock
    private PublicityRepository publicityRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll(){
        Mockito.when(publicityRepository.findAll()).thenReturn(new ArrayList<PublicityEntity>());
        ResponseBase<List<ResponsePublicity>> result = publicityRepositoryAdapter.getAll();
        assertNotNull(result);
    }
    @Test
    void get(){
        Mockito.when(publicityRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(PublicityEntityHelper.createPublicityEntity()));
        ResponseBase<ResponsePublicity> result = publicityRepositoryAdapter.get(1L);
        assertNotNull(result);
    }

    @Test
    void getAllPagination(){
        Mockito.when(publicityRepository.findAll(Mockito.any(Pageable.class))).thenReturn(PublicityEntityHelper.createPublicityEntityPage());
        ResponseBase<List<ResponsePublicity>> result = publicityRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
    }

    @Test
    void getAllPagination_EMPTY(){
        Mockito.when(publicityRepository.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<PublicityEntity>(new ArrayList<PublicityEntity>()));
        ResponseBase<List<ResponsePublicity>> result = publicityRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
        assertTrue(result.getData().isEmpty());
    }

    @Test
    void update(){
        Mockito.when(publicityRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(PublicityEntityHelper.createPublicityEntity()));
        ResponseBase<ResponsePublicity> result = publicityRepositoryAdapter.update(1L, RequestPublicityHelper.createRequestPublicity());
        assertNotNull(result);
    }

    @Test
    void create(){
        ResponseBase<ResponsePublicity> result = publicityRepositoryAdapter.create(RequestPublicityHelper.createRequestPublicity());
        assertNotNull(result);
    }
}
