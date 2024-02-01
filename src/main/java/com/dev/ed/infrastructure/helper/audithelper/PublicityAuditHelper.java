package com.dev.ed.infrastructure.helper.audithelper;

import com.dev.ed.infrastructure.entity.PublicityEntity;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.DateUtil;

public class PublicityAuditHelper {

    private PublicityAuditHelper(){

    }
    public static void setPublicityAuditCreate(PublicityEntity publicityEntity, String user){
        publicityEntity.setDateCreate(DateUtil.getTimestamp());
        publicityEntity.setUserCreate(user);
        publicityEntity.setStatus(ConstantUtil.DEFAULT_STATUS_ACTIVE);
    }
    public static void setPublicityAuditModif(PublicityEntity publicityEntity, String user){
        publicityEntity.setDateModif(DateUtil.getTimestamp());
        publicityEntity.setUserModif(user);
    }

    public static void setPublicityAuditDel(PublicityEntity publicityEntity, String user){
        publicityEntity.setDateDel(DateUtil.getTimestamp());
        publicityEntity.setUserDel(user);
        publicityEntity.setStatus(ConstantUtil.DEFAULT_STATUS_INACTIVE);
    }
}
