package com.cloud.service.domain.dto;

import com.cloud.service.domain.entity.AddressEntity;
import com.cloud.service.domain.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用户表DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserEntity {

    @Serial
    private static final long serialVersionUID = 1L;
}
