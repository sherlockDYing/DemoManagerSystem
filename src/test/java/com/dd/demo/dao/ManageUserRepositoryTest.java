package com.dd.demo.dao;

import com.dd.demo.bo.UserResourceBO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManageUserRepositoryTest {

    @Autowired
    private ManageUserRepository manageUserRepository;

    private UserResourceBO buildBO(Long userId) {
        UserResourceBO bo = new UserResourceBO();
        bo.setUserId(userId);
        bo.setEndpoint(new HashSet<>() {{
            add("resource A");
            add("resource B");
        }});
        return bo;
    }

    @Test
    void save() {
        UserResourceBO bo = buildBO((long) Integer.MAX_VALUE);
        manageUserRepository.save(bo);
        File file = new File(manageUserRepository.buildPath((long) Integer.MAX_VALUE));
        assertTrue(file.exists());
        UserResourceBO rbo = manageUserRepository.read((long) Integer.MAX_VALUE);
        assertNotNull(rbo);
        file.delete();
    }

}