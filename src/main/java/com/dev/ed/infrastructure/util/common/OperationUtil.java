package com.dev.ed.infrastructure.util.common;

import org.springframework.data.domain.Sort;

import java.util.Objects;

public class OperationUtil {

    public static Sort createSort(String sort, String id){
        return Objects.equals(sort,ConstantUtil.DEFAULT_ASCENDING_VALUE) ? Sort.by(id).ascending() : Sort.by(id).descending();
    }
}
