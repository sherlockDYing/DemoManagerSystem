package com.dd.demo.common;

import lombok.Getter;

@Getter
public enum CustomExceptionEnum {
    INVALID_PERMISSION(403, "not admin"),
    NOT_FOUND(404, "resource not found"),
    INTERNAL_EXCEPTION(500, "internal exception");


    private final Integer code;
    private final String message;

    CustomExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
