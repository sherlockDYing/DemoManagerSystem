package com.dd.demo.service;

import com.dd.demo.bo.UserResourceBO;

public interface ManageUserService {

    boolean addUser(UserResourceBO userResourceBO);

    boolean checkResource(Long userId, String resource);

}
