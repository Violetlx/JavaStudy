package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.cloud.service.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 * @TableName user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="user")
@Schema(description = "用户表")
public class UserEntity implements Serializable {
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @TableField(value = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @Schema(description = "密码，加密存储")
    @TableField(value = "password")
    private String password;

    /**
     * 注册手机号
     */
    @Schema(description = "注册手机号")
    @TableField(value = "phone")
    private String phone;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 使用状态（1正常 2冻结）
     */
    @Schema(description = "使用状态（1正常 2冻结）")
    @TableField(value = "status")
    private UserStatus status;

    /**
     * 账户余额
     */
    @Schema(description = "账户余额")
    @TableField(value = "balance")
    private Integer balance;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}