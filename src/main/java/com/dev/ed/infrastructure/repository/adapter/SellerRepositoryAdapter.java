package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestSeller;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseSeller;
import com.dev.ed.domain.ports.out.SellerOut;
import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.helper.audithelper.SellerAuditHelper;
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
public class SellerRepositoryAdapter implements SellerOut {

    private final SellerRepository sellerRepository;

    @Override
    public ResponseBase<ResponseSeller> create(RequestSeller request) {
        ResponseBase<ResponseSeller> result = new ResponseBase<>();
        SellersEntity sellersEntity = SellerMapper.MAPPER.mapToSellersEntity(request);
        SellerAuditHelper.setSellerAuditCreate(sellersEntity, ConstantUtil.DEFAULT_USER);
        ResponseSeller responseSellerSaved = SellerMapper.MAPPER.mapToResponseSeller(sellerRepository.save(sellersEntity));
        result.setMessage("Guardado Ok");
        result.setData(responseSellerSaved);
        return result;
    }

    @Override
    public ResponseBase<ResponseSeller> update(Long code, RequestSeller request) {
        ResponseBase<ResponseSeller> result = new ResponseBase<>();
        SellersEntity sellersEntity = sellerRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.VENDEDOR.name()));
        SellersEntity sellersEntityUpdated = SellerMapper.MAPPER.mapRequestToEntity(request, sellersEntity);
        SellerAuditHelper.setSellerAuditModif(sellersEntityUpdated, ConstantUtil.DEFAULT_USER);
        ResponseSeller responseSeller = SellerMapper.MAPPER.mapToResponseSeller(sellerRepository.save(sellersEntityUpdated));
        result.setMessage("Actualizado ok");
        result.setData(responseSeller);
        return result;
    }

    @Override
    public ResponseBase<ResponseSeller> get(Long code) {
        ResponseBase<ResponseSeller> result = new ResponseBase<>();
        SellersEntity sellersEntity = sellerRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.VENDEDOR.name()));
        ResponseSeller responseSeller = SellerMapper.MAPPER.mapToResponseSeller(sellersEntity);
        result.setMessage("Registro encontrado");
        result.setData(responseSeller);
        return result;
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAll() {
        ResponseBase<List<ResponseSeller>> result = new ResponseBase<>();
        List<SellersEntity> sellersEntityList = sellerRepository.findAll();
        List<ResponseSeller> responseSeller = SellerMapper.MAPPER.setResponseSellerList(sellersEntityList);
        result.setMessage("Listado de registro");
        result.setData(responseSeller);
        return result;
    }

    @Override
    public ResponseBase<List<ResponseSeller>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponseSeller>> result = new ResponseBase<>();
        Page<SellersEntity> sellersEntityPage = sellerRepository.findAll(PageRequest.of(page,limit, OperationUtil.createSort(sort,"id")));
        if(sellersEntityPage.isEmpty()){
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(sellersEntityPage.getNumber(), sellersEntityPage.getNumberOfElements(), sellersEntityPage.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(SellerMapper.MAPPER.setResponseSellerList(sellersEntityPage.getContent()));
        }
        return result;
    }

    @Override
    public ResponseBase<ResponseSeller> delete(Long id) {
        ResponseBase<ResponseSeller> result = new ResponseBase<>();
        SellersEntity sellersEntity = sellerRepository.findById(id).orElseThrow(()-> new IdNotFoundException(TablesName.VENDEDOR.name()));
        SellerAuditHelper.setSellerAuditDel(sellersEntity, ConstantUtil.DEFAULT_USER);
        ResponseSeller responseSeller = SellerMapper.MAPPER.mapToResponseSeller(sellerRepository.save(sellersEntity));
        result.setMessage("Registro eliminado con Exito");
        result.setData(responseSeller);
        return result;
    }
}
