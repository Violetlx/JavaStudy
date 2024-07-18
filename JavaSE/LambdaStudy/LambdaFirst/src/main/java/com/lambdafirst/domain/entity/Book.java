package com.lambdafirst.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode  //用于后期去重使用
public class Book implements Serializable {
    /**
     * 书籍ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 书名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类  一本书有多个分类  "哲学,小说"
     */
    @TableField(value = "category")
    private String category;

    /**
     * 评分
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 简介
     */
    @TableField(value = "intro")
    private String intro;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}