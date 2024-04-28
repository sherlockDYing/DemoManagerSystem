package com.dd.demo.service;

import com.dd.demo.bo.UserResourceBO;
import com.dd.demo.dao.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserServiceImpl implements ManageUserService {

    @Autowired
    private ManageUserRepository manageUserRepository;

    @Override
    public boolean addUser(UserResourceBO userResourceBO) {
        if (userResourceBO == null) {
            return false;
        }
        return manageUserRepository.save(userResourceBO);
    }

    @Override
    public boolean checkResource(Long userId, String resource) {
        if (userId == null) {
            return false;
        }
        UserResourceBO userResourceBO = manageUserRepository.read(userId);
        if (userResourceBO == null) {
            return false;
        }
        return userResourceBO.getEndpoint().contains(resource);
    }
}
