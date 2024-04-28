package com.dd.demo.bo;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserResourceBO {

    private Long userId;

    private Set<String> endpoint;

}
