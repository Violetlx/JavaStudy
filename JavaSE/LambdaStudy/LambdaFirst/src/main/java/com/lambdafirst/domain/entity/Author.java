package com.lambdafirst.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * @TableName author
 */
@TableName(value ="author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode  //用于后期去重使用
public class Author implements Serializable {
    /**
     * 作者ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 作者名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 作者年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 作者简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 作者的书籍
     */
    @TableField(exist = false)
    private List<Book> books;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}