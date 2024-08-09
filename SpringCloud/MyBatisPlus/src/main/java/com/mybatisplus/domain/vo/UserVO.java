package com.mybatisplus.domain.vo;

import com.mybatisplus.domain.entity.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 用户表VO
 * @author lixuan
 * @Date 2024/8/7 17:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends UserEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "地址列表")
    private List<AddressVO> addressList;

}
