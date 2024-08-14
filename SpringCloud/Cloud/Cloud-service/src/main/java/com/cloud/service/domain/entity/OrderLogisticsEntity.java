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
 * 订单日志表
 * @author lixuan
 * @TableName order_logistics
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="order_logistics")
@Schema(description = "订单日志表")
public class OrderLogisticsEntity implements Serializable {
    /**
     * 订单id，与订单表一对一
     */
    @Schema(description = "订单id，与订单表一对一")
    @TableId(value = "order_id")
    private Long orderId;

    /**
     * 物流单号
     */
    @Schema(description = "物流单号")
    @TableField(value = "logistics_number")
    private String logisticsNumber;

    /**
     * 物流公司名称
     */
    @Schema(description = "物流公司名称")
    @TableField(value = "logistics_company")
    private String logisticsCompany;

    /**
     * 收件人
     */
    @Schema(description = "收件人")
    @TableField(value = "contact")
    private String contact;

    /**
     * 收件人手机号码
     */
    @Schema(description = "收件人手机号码")
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 省
     */
    @Schema(description = "省")
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @Schema(description = "市")
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @Schema(description = "区")
    @TableField(value = "town")
    private String town;

    /**
     * 街道
     */
    @Schema(description = "街道")
    @TableField(value = "street")
    private String street;

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