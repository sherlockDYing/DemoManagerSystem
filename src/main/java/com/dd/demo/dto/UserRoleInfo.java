package com.dd.demo.dto;

import lombok.Data;

@Data
public class UserRoleInfo {
    private Long userId;
    private String accountName;
    private String role;
}
