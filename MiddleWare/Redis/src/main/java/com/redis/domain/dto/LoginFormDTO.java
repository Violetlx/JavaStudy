package com.redis.domain.dto;

import lombok.Data;

/**
 * @author 1045754
 */
@Data
public class LoginFormDTO {
    private String phone;
    private String code;
    private String password;
}
