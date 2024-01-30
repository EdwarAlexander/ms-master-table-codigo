package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.domain.ports.out.CapturesOut;
import com.dev.ed.infrastructure.entity.CapturesEntity;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.helper.audithelper.CapturesAuditHelper;
import com.dev.ed.infrastructure.helper.mappers.CapturesMapper;
import com.dev.ed.infrastructure.repository.CapturesRepository;
import com.dev.ed.infrastructure.repository.CustomerRepository;
import com.dev.ed.infrastructure.repository.SellerRepository;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.OperationUtil;
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.PaginationMapper;
import com.dev.ed.infrastructure.util.mapper.SellerMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
@AllArgsConstructor
public class CapturesRepositoryAdapter implements CapturesOut {

    private final CapturesRepository capturesRepository;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;

    @Override
    public ResponseBase<ResponseCaptures> create(RequestCaptures request) {
        ResponseBase<ResponseCaptures> result = new ResponseBase<>();
        CustomerEntity customerEntity = customerRepository.findById(request.getCustomer_id()).orElseThrow(()-> new IdNotFoundException(TablesName.cliente.name()));
        SellersEntity sellersEntity = sellerRepository.findById(request.getSeller_id()).orElseThrow(()-> new IdNotFoundException(TablesName.vendedor.name()));
        CapturesEntity capturesEntity = CapturesMapper.mapToCaptureEntity(request, customerEntity, sellersEntity);
        CapturesAuditHelper.SetCapturesAuditCreate(capturesEntity, ConstantUtil.DEFAULT_USER);
        ResponseCaptures responseCaptures = CapturesMapper.mapToResponseCaptures(capturesRepository.save(capturesEntity));
        result.setMessage("registro ok");
        result.setData(responseCaptures);
        return result;
    }

    @Override
    public ResponseBase<ResponseCaptures> update(Long code, RequestCaptures request) {
        ResponseBase<ResponseCaptures> result = new ResponseBase<>();
        CapturesEntity capturesEntity = capturesRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.captacion.name()));
        CustomerEntity customerEntity = customerRepository.findById(request.getCustomer_id()).orElseThrow(()-> new IdNotFoundException(TablesName.cliente.name()));
        SellersEntity sellersEntity = sellerRepository.findById(request.getSeller_id()).orElseThrow(()-> new IdNotFoundException(TablesName.vendedor.name()));
        CapturesEntity capturesEntityUpdated = CapturesMapper.mapToCaptureEntityUpdated(request, customerEntity, sellersEntity, capturesEntity);
        CapturesAuditHelper.setCapturesAuditModif(capturesEntityUpdated, ConstantUtil.DEFAULT_USER);
        ResponseCaptures responseCaptures = CapturesMapper.mapToResponseCaptures(capturesRepository.save(capturesEntityUpdated));
        result.setMessage("registro actualizado");
        result.setData(responseCaptures);
        return result;
    }

    @Override
    public ResponseBase<ResponseCaptures> get(Long code) {
        ResponseBase<ResponseCaptures> result = new ResponseBase<>();
        CapturesEntity capturesEntity = capturesRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.captacion.name()));
        ResponseCaptures responseCaptures = CapturesMapper.mapToResponseCaptures(capturesEntity);
        result.setMessage("registro encontrado");
        result.setData(responseCaptures);
        return result;
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAll() {
        ResponseBase<List<ResponseCaptures>> result = new ResponseBase<>();
        List<CapturesEntity> capturesEntityList = capturesRepository.findAll();
        List<ResponseCaptures> responseCapturesList = CapturesMapper.mapToResponseCapturesList(capturesEntityList);
        result.setData(responseCapturesList);
        result.setMessage("listado de registros");
        return result;
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseCaptures>> result = new ResponseBase<>();
        Page<CapturesEntity> capturesEntityPage = capturesRepository.findAll(PageRequest.of(page,limit, OperationUtil.createSort(sort,"id")));
        if(capturesEntityPage.isEmpty()){
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(capturesEntityPage.getNumber(), capturesEntityPage.getNumberOfElements(), capturesEntityPage.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(CapturesMapper.mapToResponseCapturesList(capturesEntityPage.getContent()));
        }
        return result;
    }

    @Override
    public ResponseBase<List<ResponseCapturesPage>> getCapturePage(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseCapturesPage>> result = new ResponseBase<>();
        Page<ResponseCapturesPage> responseCapturesPages = capturesRepository.getCapture(PageRequest.of(page,limit, OperationUtil.createSort(sort,"id")));
        if(responseCapturesPages.isEmpty()){
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(responseCapturesPages.getNumber(), responseCapturesPages.getNumberOfElements(), responseCapturesPages.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(responseCapturesPages.getContent());
        }
        return result;
    }

    @Override
    public ResponseBase<ResponseCaptures> delete(Long id) {
        ResponseBase<ResponseCaptures> result = new ResponseBase<>();
        CapturesEntity capturesEntity = capturesRepository.findById(id).orElseThrow(()-> new IdNotFoundException(TablesName.captacion.name()));
        CapturesEntity capturesEntityUpdated = CapturesMapper.mapToCaptureEntityDelete(capturesEntity);
        CapturesAuditHelper.setCapturesAuditDel(capturesEntityUpdated, ConstantUtil.DEFAULT_USER);
        ResponseCaptures responseCaptures = CapturesMapper.mapToResponseCaptures(capturesRepository.save(capturesEntityUpdated));
        result.setMessage("registro eliminado");
        result.setData(responseCaptures);
        return result;
    }
}
