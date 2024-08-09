package com.mybatisplus.domain.dto;

import com.mybatisplus.domain.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用户表DTO
 * @author lixuan
 * @Date 2024/8/7 17:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserEntity {

    @Serial
    private static final long serialVersionUID = 1L;
}
