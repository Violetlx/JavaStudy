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
 * 商品表
 * @TableName item
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="item")
@Schema(description = "商品表")
public class ItemEntity implements Serializable {
    /**
     * 商品id
     */
    @Schema(description = "商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * SKU名称
     */
    @Schema(description = "SKU名称")
    @TableField(value = "name")
    private String name;

    /**
     * 价格（分）
     */
    @Schema(description = "价格（分）")
    @TableField(value = "price")
    private Integer price;

    /**
     * 库存数量
     */
    @Schema(description = "库存数量")
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 商品图片
     */
    @Schema(description = "商品图片")
    @TableField(value = "image")
    private String image;

    /**
     * 类目名称
     */
    @Schema(description = "类目名称")
    @TableField(value = "category")
    private String category;

    /**
     * 品牌名称
     */
    @Schema(description = "品牌名称")
    @TableField(value = "brand")
    private String brand;

    /**
     * 规格
     */
    @Schema(description = "规格")
    @TableField(value = "spec")
    private String spec;

    /**
     * 销量
     */
    @Schema(description = "销量")
    @TableField(value = "sold")
    private Integer sold;

    /**
     * 评论数
     */
    @Schema(description = "评论数")
    @TableField(value = "comment_count")
    private Integer commentCount;

    /**
     * 是否是推广广告，true/false
     */
    @Schema(description = "是否是推广广告，true/false")
    @TableField(value = "isAD")
    private Integer isad;

    /**
     * 商品状态 1-正常，2-下架，3-删除
     */
    @Schema(description = "商品状态 1-正常，2-下架，3-删除")
    @TableField(value = "status")
    private Integer status;

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
     * 创建人
     */
    @Schema(description = "创建人")
    @TableField(value = "creater")
    private Long creater;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    @TableField(value = "updater")
    private Long updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}