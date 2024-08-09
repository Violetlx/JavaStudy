package com.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.mybatisplus.domain.po.UserInfo;
import com.mybatisplus.eum.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@Data
@TableName(value ="user",autoResultMap = true)
@Schema(description = "用户表")
public class UserEntity implements Serializable {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField(value = "password")
    private String password;

    /**
     * 注册手机号
     */
    @Schema(description = "注册手机号")
    @TableField(value = "phone")
    private String phone;

    /**
     * 详细信息
     */
    @Schema(description = "详细信息")
    @TableField(value = "info",typeHandler = JacksonTypeHandler.class)
    private UserInfo info;

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
     * 逻辑删除
     */
    @Schema(description = "逻辑删除")
    @TableField(value = "deleted")
    private Boolean deleted;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}