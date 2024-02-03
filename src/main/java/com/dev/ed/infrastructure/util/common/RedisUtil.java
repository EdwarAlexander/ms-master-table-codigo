package com.dev.ed.infrastructure.util.common;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class RedisUtil {

    private RedisUtil(){}
    public static String convertToJson(CustomerEntity customerEntity) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(customerEntity);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T convertFromJson(String json, Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            return null;
        }
    }
}
