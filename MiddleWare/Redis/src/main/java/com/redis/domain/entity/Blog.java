package com.redis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 用户日记表
 * @author lixuan
 * @TableName tb_blog
 */
@TableName(value ="tb_blog")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog implements Serializable {
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户图标
     */
    @TableField(exist = false)
    private String icon;

    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String name;

    /**
     * 是否点赞过了
     */
    @TableField(exist = false)
    private Boolean isLike;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 探店的照片，最多9张，多张以","隔开
     */
    @TableField(value = "images")
    private String images;

    /**
     * 探店的文字描述
     */
    @TableField(value = "content")
    private String content;

    /**
     * 点赞数量
     */
    @TableField(value = "liked")
    private Integer liked;

    /**
     * 评论数量
     */
    @TableField(value = "comments")
    private Integer comments;

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