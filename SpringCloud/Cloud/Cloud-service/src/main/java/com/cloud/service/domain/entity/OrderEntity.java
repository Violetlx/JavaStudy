package com.cloud.service.domain.entity;

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
 * 订单表
 * @author lixuan
 * @TableName order
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="order")
@Schema(description = "订单表")
public class OrderEntity implements Serializable {
    /**
     * 订单id
     */
    @Schema(description = "订单id")
    @TableId(value = "id")
    private Long id;

    /**
     * 总金额，单位为分
     */
    @Schema(description = "总金额，单位为分")
    @TableField(value = "total_fee")
    private Integer totalFee;

    /**
     * 支付类型，1、支付宝，2、微信，3、扣减余额
     */
    @Schema(description = "支付类型，1、支付宝，2、微信，3、扣减余额")
    @TableField(value = "payment_type")
    private Integer paymentType;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 订单的状态，1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消，订单关闭 6、交易结束，已评价
     */
    @Schema(description = "订单的状态，1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消，订单关闭 6、交易结束，已评价")
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 支付时间
     */
    @Schema(description = "支付时间")
    @TableField(value = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @Schema(description = "发货时间")
    @TableField(value = "consign_time")
    private Date consignTime;

    /**
     * 交易完成时间
     */
    @Schema(description = "交易完成时间")
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @Schema(description = "交易关闭时间")
    @TableField(value = "close_time")
    private Date closeTime;

    /**
     * 评价时间
     */
    @Schema(description = "评价时间")
    @TableField(value = "comment_time")
    private Date commentTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}