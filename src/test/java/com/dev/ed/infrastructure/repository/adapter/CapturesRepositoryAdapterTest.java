package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.helper.*;
import com.dev.ed.infrastructure.entity.CapturesEntity;
import com.dev.ed.infrastructure.repository.CapturesRepository;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.repository.SellerRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CapturesRepositoryAdapterTest {
    @InjectMocks
    private CapturesRepositoryAdapter capturesRepositoryAdapter;
    @Mock
    private CapturesRepository capturesRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll(){
        Mockito.when(capturesRepository.findAll()).thenReturn(new ArrayList<CapturesEntity>());
        ResponseBase<List<ResponseCaptures>> result = capturesRepositoryAdapter.getAll();
        assertNotNull(result);
    }
    @Test
    void get(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CaptureEntityHelper.createCapturesEntity()));
        ResponseBase<ResponseCaptures> result = capturesRepositoryAdapter.get(1L);
        assertNotNull(result);
    }

    @Test
    void get_Error(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            capturesRepositoryAdapter.get(1L);
        });
        assertEquals("No existe el id en la tabla CAPTACION", exception.getMessage());
    }

    @Test
    void getAllPagination(){
        Mockito.when(capturesRepository.findAll(Mockito.any(Pageable.class))).thenReturn(CaptureEntityHelper.createCapturesEntityPage());
        ResponseBase<List<ResponseCaptures>> result = capturesRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
    }

    @Test
    void getAllPagination_EMPTY(){
        Mockito.when(capturesRepository.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<CapturesEntity>(new ArrayList<CapturesEntity>()));
        ResponseBase<List<ResponseCaptures>> result = capturesRepositoryAdapter.getAllPagination(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
        assertTrue(result.getData().isEmpty());
    }

    @Test
    void update(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CaptureEntityHelper.createCapturesEntity()));
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));
        ResponseBase<ResponseCaptures> result = capturesRepositoryAdapter.update(1L, RequestCapturesHelper.createRequestCaptures());
        assertNotNull(result);
    }

    @Test
    void update_Error_Capture(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Exception exception = null;
        try{
            capturesRepositoryAdapter.update(1L, RequestCapturesHelper.createRequestCaptures());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla CAPTACION", exception.getMessage());
    }

    @Test
    void update_Error_Customer(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CaptureEntityHelper.createCapturesEntity()));
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Exception exception = null;
        try{
            capturesRepositoryAdapter.update(1L, RequestCapturesHelper.createRequestCaptures());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla CLIENTE", exception.getMessage());
    }

    @Test
    void update_Error_Seller(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CaptureEntityHelper.createCapturesEntity()));
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Exception exception = null;
        try{
            capturesRepositoryAdapter.update(1L, RequestCapturesHelper.createRequestCaptures());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla VENDEDOR", exception.getMessage());
    }
    @Test
    void create(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));
        ResponseBase<ResponseCaptures> result = capturesRepositoryAdapter.create(RequestCapturesHelper.createRequestCaptures());
        assertNotNull(result);
    }

    @Test
    void create_Error_Customer(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SellerEntityHelper.createSellersEntity()));

        Exception exception = null;
        try{
            capturesRepositoryAdapter.create(RequestCapturesHelper.createRequestCaptures());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla CLIENTE", exception.getMessage());
    }

    @Test
    void create_Error_Seller(){
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerEntityHelper.createCustomerEntity()));
        Mockito.when(sellerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Exception exception = null;
        try{
            capturesRepositoryAdapter.create(RequestCapturesHelper.createRequestCaptures());
        }catch (Exception e){
            exception = e;
        }
        assertEquals("No existe el id en la tabla VENDEDOR", exception.getMessage());
    }

    @Test
    void delete(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CaptureEntityHelper.createCapturesEntity()));
        ResponseBase<ResponseCaptures> result = capturesRepositoryAdapter.delete(1L);
        assertNotNull(result);
    }

    @Test
    void delete_Error(){
        Mockito.when(capturesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            capturesRepositoryAdapter.delete(1L);
        });
        assertEquals("No existe el id en la tabla CAPTACION", exception.getMessage());
    }

    @Test
    void getCapturePage(){
        Mockito.when(capturesRepository.getCapture(Mockito.any(Pageable.class))).thenReturn(ResponseCapturesPageHelper.createResponseCapturesPagePage());
        ResponseBase<List<ResponseCapturesPage>> result = capturesRepositoryAdapter.getCapturePage(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
    }

    @Test
    void getCapturePage_EMPTY(){
        Mockito.when(capturesRepository.getCapture(Mockito.any(Pageable.class))).thenReturn(new PageImpl<ResponseCapturesPage>(new ArrayList<ResponseCapturesPage>()));
        ResponseBase<List<ResponseCapturesPage>> result = capturesRepositoryAdapter.getCapturePage(ConstantUtil.DEFAULT_PAGE,ConstantUtil.DEFAULT_LIMIT, ConstantUtil.DEFAULT_ASCENDING_VALUE);
        assertNotNull(result);
        assertTrue(result.getData().isEmpty());
    }
}