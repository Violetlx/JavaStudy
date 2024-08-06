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
 * 商户信息表
 * @author lixuan
 * @TableName tb_shop
 */
@TableName(value ="tb_shop")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop implements Serializable {
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商铺名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 商铺类型的id
     */
    @TableField(value = "type_id")
    private Long typeId;

    /**
     * 商铺图片，多个图片以','隔开
     */
    @TableField(value = "images")
    private String images;

    /**
     * 商圈，例如陆家嘴
     */
    @TableField(value = "area")
    private String area;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 经度
     */
    @TableField(value = "x")
    private Double x;

    /**
     * 维度
     */
    @TableField(value = "y")
    private Double y;

    /**
     * 均价，取整数
     */
    @TableField(value = "avg_price")
    private Long avgPrice;

    /**
     * 销量
     */
    @TableField(value = "sold")
    private Integer sold;

    /**
     * 评论数量
     */
    @TableField(value = "comments")
    private Integer comments;

    /**
     * 评分，1~5分，乘10保存，避免小数
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 营业时间，例如 10:00-22:00
     */
    @TableField(value = "open_hours")
    private String openHours;

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
    private Double distance;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}