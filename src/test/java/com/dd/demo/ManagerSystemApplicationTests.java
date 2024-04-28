package com.dd.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;


@SpringBootTest
class ManagerSystemApplicationTests {

    public static void main(String[] args) {
        String res = "{\n" +
                "\"userId\":123456,\n" +
                "\"accountName\": \"XXXXXXX\",\n" +
                "\"role\": \"admin\"\n" +
                "}";
        System.out.println();
    }

    @Test
    void contextLoads() {

    }

}
