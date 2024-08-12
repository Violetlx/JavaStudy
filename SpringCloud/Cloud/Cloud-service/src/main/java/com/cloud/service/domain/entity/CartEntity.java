package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单详情表
 * @TableName cart
 */
@TableName(value ="cart")
@Data
public class CartEntity implements Serializable {
    /**
     * 购物车条目id 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * sku商品id
     */
    @TableField(value = "item_id")
    private Long itemId;

    /**
     * 购买数量
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 商品标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 商品动态属性键值集
     */
    @TableField(value = "spec")
    private String spec;

    /**
     * 价格,单位：分
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 商品图片
     */
    @TableField(value = "image")
    private String image;

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