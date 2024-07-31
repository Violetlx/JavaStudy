package com.redis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客评论
 * @author lixuan
 * @TableName tb_blog_comments
 */
@TableName(value ="tb_blog_comments")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogComments implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 探店id
     */
    @TableField(value = "blog_id")
    private Long blogId;

    /**
     * 关联的1级评论id，如果是一级评论，则值为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 回复的评论id
     */
    @TableField(value = "answer_id")
    private Long answerId;

    /**
     * 回复的内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 点赞数
     */
    @TableField(value = "liked")
    private Integer liked;

    /**
     * 状态，0：正常，1：被举报，2：禁止查看
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}