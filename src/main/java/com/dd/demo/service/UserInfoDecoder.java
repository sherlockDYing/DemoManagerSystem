package com.dd.demo.service;

import com.dd.demo.dto.UserRoleInfo;
import com.dd.demo.utils.JsonUtils;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class UserInfoDecoder {
    public static UserRoleInfo decode(String base64User) {
        return JsonUtils.convert(Base64.getDecoder().decode(base64User), UserRoleInfo.class);
    }
}
