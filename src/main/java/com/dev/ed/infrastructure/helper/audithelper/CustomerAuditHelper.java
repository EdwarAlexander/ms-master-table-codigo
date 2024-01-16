package com.dev.ed.infrastructure.helper.audithelper;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.dev.ed.infrastructure.util.common.DateUtil;

public class CustomerAuditHelper {

    public static void setCustomerAuditCreate(CustomerEntity customerEntity, String user){
        customerEntity.setDateCreate(DateUtil.getTimestamp());
        customerEntity.setUserCreate(user);
    }

    public static void setCustomerAuditModif(CustomerEntity customerEntity, String user){
        customerEntity.setDateModif(DateUtil.getTimestamp());
        customerEntity.setUserModif(user);
    }
}
