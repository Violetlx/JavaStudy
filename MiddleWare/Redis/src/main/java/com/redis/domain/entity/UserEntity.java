package com.redis.domain.entity;

import lombok.Data;

/**
 * 用户对象
 * @author lixuan
 * @Date 2024/7/30 11:19
 */
@Data
public class UserEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
