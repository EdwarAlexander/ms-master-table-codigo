package com.dev.ed.infrastructure.util.exception;

public class IdNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "No existe el id en la tabla %s";
    public IdNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE,tableName));
    }
}
