package com.dd.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AddUserRequest {
    private Long userId;
    private Set<String> endpoint;
}
