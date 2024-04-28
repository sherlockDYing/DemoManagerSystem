package com.dd.demo.controller;

import com.dd.demo.dto.UserRoleInfo;
import com.dd.demo.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ManageUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String buildUser(Long userId, String role) {
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userRoleInfo.setUserId(userId);
        userRoleInfo.setRole(role);
        userRoleInfo.setAccountName("xxx");
        return Base64.getEncoder().encodeToString(JsonUtils.serialize(userRoleInfo).getBytes());
    }

    @Test
    void addUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/admin/addUser").contentType(MediaType.APPLICATION_JSON)
                .header("user", buildUser(1223456L, "admin"))
                .content("{\n" + "\"userId\":123456,\n" + "\"endpoint\" :[\n" + "\"resource A\",\n" + "\"resource B\",\n" + "\"resource C\"\n" + "]\n" + "}")).andExpect(status().isOk()).andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), "{\"code\":200,\"message\":\"success\",\"data\":true}");
    }


    @Test
    void addUserFailByUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/admin/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .header("user", buildUser(1234567L, "user"))
                .content("{\n" + "\"userId\":123456,\n" + "\"endpoint\" :[\n" + "\"resource A\",\n" + "\"resource B\",\n" + "\"resource C\"\n" + "]\n" + "}")).andExpect(status().isOk()).andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), "{\"code\":403,\"message\":\"not admin\",\"data\":null}");
    }

    @Test
    void checkResource() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/resource A")
                        .header("user", buildUser(123456L, "admin")))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), "{\"code\":200,\"message\":\"success\",\"data\":true}");
    }
}