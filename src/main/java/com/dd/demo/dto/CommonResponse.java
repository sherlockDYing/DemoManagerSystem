package com.dd.demo.dto;

import com.dd.demo.common.CustomExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse {
    private Integer code;
    private String message;
    private Object data;

    public static CommonResponse success(Object data) {
        return new CommonResponse(200, "success", data);
    }

    public static CommonResponse fail(Object data) {
        return new CommonResponse(500, "fail", data);
    }

    public static CommonResponse fail(CustomExceptionEnum exceptionEnum) {
        return new CommonResponse(exceptionEnum.getCode(), exceptionEnum.getMessage(), null);
    }
}
