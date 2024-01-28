package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestPublicity;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCustomer;
import com.dev.ed.domain.model.response.ResponsePublicity;
import com.dev.ed.domain.ports.out.PublicityOut;
import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.entity.PublicityEntity;
import com.dev.ed.infrastructure.helper.audithelper.PublicityAuditHelper;
import com.dev.ed.infrastructure.repository.PublicityRepository;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.OperationUtil;
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import com.dev.ed.infrastructure.util.mapper.CustomerMapper;
import com.dev.ed.infrastructure.util.mapper.PaginationMapper;
import com.dev.ed.infrastructure.util.mapper.PublicityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
@AllArgsConstructor
public class PublicityRepositoryAdapter implements PublicityOut {

    private final PublicityRepository publicityRepository;

    @Override
    public ResponseBase<ResponsePublicity> create(RequestPublicity request) {
        ResponseBase<ResponsePublicity> result = new ResponseBase<>();
        PublicityEntity publicityEntity = PublicityMapper.MAPPER.mapToPublicityEntity(request);
        PublicityAuditHelper.setPublicityAuditCreate(publicityEntity, ConstantUtil.DEFAULT_USER);
        ResponsePublicity responsePublicitySaved = PublicityMapper.MAPPER.mapToResponsePublicity(publicityRepository.save(publicityEntity));
        result.setMessage("Guardado ok");
        result.setData(responsePublicitySaved);
        return result;
    }

    @Override
    public ResponseBase<ResponsePublicity> update(Long code, RequestPublicity request) {
        ResponseBase<ResponsePublicity> result = new ResponseBase<>();
        PublicityEntity publicityEntity = publicityRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.publicidad.name()));
        PublicityEntity publicityEntityUpdate = PublicityMapper.MAPPER.mapRequestToEntity(request, publicityEntity);
        PublicityAuditHelper.setPublicityAuditModif(publicityEntityUpdate, ConstantUtil.DEFAULT_USER);
        ResponsePublicity responsePublicity = PublicityMapper.MAPPER.mapToResponsePublicity(publicityRepository.save(publicityEntityUpdate));
        result.setMessage("Actualizado ok");
        result.setData(responsePublicity);
        return result;
    }

    @Override
    public ResponseBase<ResponsePublicity> get(Long code) {
        ResponseBase<ResponsePublicity> result = new ResponseBase<>();
        PublicityEntity publicityEntity = publicityRepository.findById(code).orElseThrow(()-> new IdNotFoundException(TablesName.publicidad.name()));
        ResponsePublicity responsePublicity = PublicityMapper.MAPPER.mapToResponsePublicity(publicityEntity);
        result.setMessage("registro encontrado");
        result.setData(responsePublicity);
        return result;
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAll() {
        ResponseBase<List<ResponsePublicity>> result = new ResponseBase<>();
        List<PublicityEntity> publicityEntityList = publicityRepository.findAll();
        List<ResponsePublicity> responsePublicityList = PublicityMapper.MAPPER.setResponsePublicityList(publicityEntityList);
        result.setMessage("Listado de registro");
        result.setData(responsePublicityList);
        return result;
    }

    @Override
    public ResponseBase<List<ResponsePublicity>> getAllPagination(Integer page, Integer limit, String sort) {
        ResponseBase<List<ResponsePublicity>> result = new ResponseBase<>();
        Page<PublicityEntity> publicityEntityPage = publicityRepository.findAll(PageRequest.of(page,limit, OperationUtil.createSort(sort,"id")));
        if(publicityEntityPage.isEmpty()){
            result.setPagination(PaginationMapper.MAPPER.setPagination(0,0,0));
            result.setMessage("No hay registro a mostrar");
            result.setData(Collections.emptyList());
        } else {
            result.setPagination(PaginationMapper.MAPPER.setPagination(publicityEntityPage.getNumber(), publicityEntityPage.getNumberOfElements(), publicityEntityPage.getTotalPages()));
            result.setMessage("Se hay registro a mostrar");
            result.setData(PublicityMapper.MAPPER.setResponsePublicityList(publicityEntityPage.getContent()));
        }
        return result;
    }
}
