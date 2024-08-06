package com.redis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * @author lixuan
 * @TableName tb_user_info
 */
@TableName(value ="tb_user_info")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {
    /**
     * 主键，用户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 城市名称
     */
    @TableField(value = "city")
    private String city;

    /**
     * 个人介绍，不要超过128个字符
     */
    @TableField(value = "introduce")
    private String introduce;

    /**
     * 粉丝数量
     */
    @TableField(value = "fans")
    private Integer fans;

    /**
     * 关注的人的数量
     */
    @TableField(value = "followee")
    private Integer followee;

    /**
     * 性别，0：男，1：女
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 积分
     */
    @TableField(value = "credits")
    private Integer credits;

    /**
     * 会员级别，0~9级,0代表未开通会员
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}