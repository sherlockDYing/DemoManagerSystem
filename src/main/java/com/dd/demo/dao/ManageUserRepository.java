package com.dd.demo.dao;

import com.dd.demo.bo.UserResourceBO;
import com.dd.demo.utils.JsonUtils;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class ManageUserRepository {

    public boolean save(UserResourceBO bo) {
        String content = JsonUtils.serialize(bo);
        try (BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(buildPath(bo.getUserId())))) {
            bf.write(content.getBytes());
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public UserResourceBO read(Long userId) {
        if (userId == null) {
            return null;
        }
        String fileName = buildPath(userId);
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("file does not exist!");
        }
        try (FileInputStream in = new FileInputStream(file)) {
            return JsonUtils.convert(in.readAllBytes(), UserResourceBO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String buildPath(Long userId) {
        return "repo/user." + userId + ".txt";
    }

}
