package com.dev.ed.infrastructure.util.common;

import java.sql.Timestamp;

public class DateUtil {
    private DateUtil(){}
    public static Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
}
