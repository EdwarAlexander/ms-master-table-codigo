package com.dev.ed.infrastructure.helper.audithelper;

import com.dev.ed.infrastructure.entity.CapturesEntity;
import com.dev.ed.infrastructure.entity.SellersEntity;
import com.dev.ed.infrastructure.util.common.ConstantUtil;
import com.dev.ed.infrastructure.util.common.DateUtil;

public class CapturesAuditHelper {

    public static void SetCapturesAuditCreate(CapturesEntity capturesEntity, String user){
        capturesEntity.setDateCreate(DateUtil.getTimestamp());
        capturesEntity.setUserCreate(user);
        capturesEntity.setStatus(ConstantUtil.DEFAULT_STATUS_ACTIVE);
    }
    public static void setCapturesAuditModif(CapturesEntity capturesEntity, String user){
        capturesEntity.setDateModif(DateUtil.getTimestamp());
        capturesEntity.setUserModif(user);
    }

    public static void setCapturesAuditDel(CapturesEntity capturesEntity, String user){
        capturesEntity.setDateDel(DateUtil.getTimestamp());
        capturesEntity.setUserDel(user);
        capturesEntity.setStatus(ConstantUtil.DEFAULT_STATUS_INACTIVE);
    }
}
