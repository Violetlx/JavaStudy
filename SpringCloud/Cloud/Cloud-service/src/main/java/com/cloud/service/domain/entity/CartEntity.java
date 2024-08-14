package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情表
 * @TableName cart
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="cart")
@Schema(description = "订单详情表")
public class CartEntity implements Serializable {
    /**
     * 购物车条目id 
     */
    @Schema(description = "购物车条目id ")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    /**
     * sku商品id
     */
    @Schema(description = "sku商品id")
    @TableField(value = "item_id")
    private Long itemId;

    /**
     * 购买数量
     */
    @Schema(description = "购买数量")
    @TableField(value = "num")
    private Integer num;

    /**
     * 商品标题
     */
    @Schema(description = "商品标题")
    @TableField(value = "name")
    private String name;

    /**
     * 商品动态属性键值集
     */
    @Schema(description = "商品动态属性键值集")
    @TableField(value = "spec")
    private String spec;

    /**
     * 价格,单位：分
     */
    @Schema(description = "价格,单位：分")
    @TableField(value = "price")
    private Integer price;

    /**
     * 商品图片
     */
    @Schema(description = "商品图片")
    @TableField(value = "image")
    private String image;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}