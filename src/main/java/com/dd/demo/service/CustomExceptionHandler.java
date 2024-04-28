package com.dd.demo.service;

import com.dd.demo.common.CustomExceptionEnum;
import com.dd.demo.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(Exception e) {
        log.error("exception ", e);
        return CommonResponse.fail(CustomExceptionEnum.INTERNAL_EXCEPTION);
    }
}
