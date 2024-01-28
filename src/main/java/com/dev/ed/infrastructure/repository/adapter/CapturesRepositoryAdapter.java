package com.dev.ed.infrastructure.repository.adapter;

import com.dev.ed.domain.model.request.RequestCaptures;
import com.dev.ed.domain.model.response.ResponseBase;
import com.dev.ed.domain.model.response.ResponseCaptures;
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
import com.dev.ed.infrastructure.util.enums.TablesName;
import com.dev.ed.infrastructure.util.exception.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public ResponseBase<ResponseCaptures> get(Long code) {
        return null;
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAll() {
        return null;
    }

    @Override
    public ResponseBase<List<ResponseCaptures>> getAllPagination(Integer page, Integer limit, String sort) {
        return null;
    }
}
