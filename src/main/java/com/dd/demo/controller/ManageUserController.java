package com.dd.demo.controller;

import com.dd.demo.bo.UserResourceBO;
import com.dd.demo.common.CustomExceptionEnum;
import com.dd.demo.dto.AddUserRequest;
import com.dd.demo.dto.CommonResponse;
import com.dd.demo.dto.UserRoleInfo;
import com.dd.demo.service.AdminOnly;
import com.dd.demo.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManageUserController {

    @Autowired
    private ManageUserService manageUserService;


    @AdminOnly
    @PostMapping("/admin/addUser")
    public CommonResponse addUser(@RequestAttribute UserRoleInfo userRoleInfo, @RequestBody AddUserRequest addUserRequest) {
        if (addUserRequest.getUserId() == null || addUserRequest.getEndpoint() == null) {
            return new CommonResponse(500, "invalid parameters", false);
        }
        UserResourceBO bo = new UserResourceBO();
        bo.setUserId(addUserRequest.getUserId());
        bo.setEndpoint(addUserRequest.getEndpoint());
        if (manageUserService.addUser(bo)) {
            return CommonResponse.success(true);
        } else {
            return CommonResponse.fail(false);
        }
    }


    @GetMapping("/user/{resource}")
    public CommonResponse checkResource(@RequestAttribute UserRoleInfo userRoleInfo, @PathVariable("resource") String resource) {
        if (manageUserService.checkResource(userRoleInfo.getUserId(), resource)) {
            return CommonResponse.success(true);
        } else {
            return CommonResponse.fail(CustomExceptionEnum.NOT_FOUND);
        }
    }
}
