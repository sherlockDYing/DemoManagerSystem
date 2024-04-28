package com.dd.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convert(byte[] source, Class<T> target) {
        try {
            return objectMapper.readValue(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convert(String src, Class<T> target) {
        try {
            return objectMapper.readValue(src, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String serialize(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
