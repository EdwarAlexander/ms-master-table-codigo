package com.dev.ed.infrastructure.helper.audithelper;

import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.DateUtil;

public class SellerAuditHelper {

    private SellerAuditHelper(){}
    public static void setSellerAuditCreate(SellersEntity sellersEntity, String user){
        sellersEntity.setDateCreate(DateUtil.getTimestamp());
        sellersEntity.setUserCreate(user);
        sellersEntity.setStatus(ConstantUtil.DEFAULT_STATUS_ACTIVE);
    }
    public static void setSellerAuditModif(SellersEntity sellersEntity, String user){
        sellersEntity.setDateModif(DateUtil.getTimestamp());
        sellersEntity.setUserModif(user);
    }

    public static void setSellerAuditDel(SellersEntity sellersEntity, String user){
        sellersEntity.setDateDel(DateUtil.getTimestamp());
        sellersEntity.setUserDel(user);
        sellersEntity.setStatus(ConstantUtil.DEFAULT_STATUS_INACTIVE);
    }
}
