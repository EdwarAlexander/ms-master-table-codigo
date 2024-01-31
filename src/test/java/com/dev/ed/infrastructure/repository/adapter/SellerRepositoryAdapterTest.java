package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.helper.RequestSellerHelper;
import com.dev.ed.helper.SellerEntityHelper;
import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.repository.SellerRepository;
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

import static org.junit.jupiter.api.Assertions.*;

class SellerRepositoryAdapterTest {
    @InjectMocks
    private SellerRepositoryAdapter sellerRepositoryAdapter;
    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll(){
        Mockito.when(sellerRepository.findAll()).thenReturn(new ArrayList<SellersEntity>());
        ResponseBase<List<ResponseSeller>> result = sellerRepositoryAdapter.getAll();
        assertNotNull(result);
    }
    @Test
    void get(){
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));
        ResponseBase<ResponseSeller> result = sellerRepositoryAdapter.get(1L);
        assertNotNull(result);
    }

    @Test
    void getAllPagination(){
        Mockito.when(sellerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(SellerEntityHelper.createSellersEntityPage());
        ResponseBase<List<ResponseSeller>> result = sellerRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
    }

    @Test
    void getAllPagination_EMPTY(){
        Mockito.when(sellerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<SellersEntity>(new ArrayList<SellersEntity>()));
        ResponseBase<List<ResponseSeller>> result = sellerRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
        assertTrue(result.getData().isEmpty());
    }

    @Test
    void update(){
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));
        ResponseBase<ResponseSeller> result = sellerRepositoryAdapter.update(1L, RequestSellerHelper.createRequestSeller());
        assertNotNull(result);
    }

    @Test
    void create(){
        ResponseBase<ResponseSeller> result = sellerRepositoryAdapter.create(RequestSellerHelper.createRequestSeller());
        assertNotNull(result);
    }

    @Test
    void delete(){
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));
        ResponseBase<ResponseSeller> result = sellerRepositoryAdapter.delete(1L);
        assertNotNull(result);
    }
}