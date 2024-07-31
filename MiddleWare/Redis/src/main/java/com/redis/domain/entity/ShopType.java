package com.redis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户类型表
 * @author lixuan
 * @TableName tb_shop_type
 */
@TableName(value ="tb_shop_type")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopType implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 顺序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonIgnore
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @JsonIgnore
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}