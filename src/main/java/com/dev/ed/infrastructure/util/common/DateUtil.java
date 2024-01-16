package com.dev.ed.infrastructure.util.common;

import java.sql.Timestamp;

public class DateUtil {
    public static Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}
