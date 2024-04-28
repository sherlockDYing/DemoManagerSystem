package com.dd.demo.service;

import com.dd.demo.common.CustomExceptionEnum;
import com.dd.demo.dto.CommonResponse;
import com.dd.demo.dto.UserRoleInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdminAspect {

    @Pointcut("@annotation(com.dd.demo.service.AdminOnly)")
    private void adminOnlyPointcut() {
    }

    @Around("adminOnlyPointcut()")
    public Object adminOnlyAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] obj = proceedingJoinPoint.getArgs();
        UserRoleInfo userRoleInfo = (UserRoleInfo) obj[0];
        if (!"admin".equals(userRoleInfo.getRole())) {
            return CommonResponse.fail(CustomExceptionEnum.INVALID_PERMISSION);
        }
        return proceedingJoinPoint.proceed();
    }
}
