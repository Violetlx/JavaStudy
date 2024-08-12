package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName order_logistics
 */
@TableName(value ="order_logistics")
@Data
public class OrderLogisticsEntity implements Serializable {
    /**
     * 订单id，与订单表一对一
     */
    @TableId(value = "order_id")
    private Long orderId;

    /**
     * 物流单号
     */
    @TableField(value = "logistics_number")
    private String logisticsNumber;

    /**
     * 物流公司名称
     */
    @TableField(value = "logistics_company")
    private String logisticsCompany;

    /**
     * 收件人
     */
    @TableField(value = "contact")
    private String contact;

    /**
     * 收件人手机号码
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @TableField(value = "town")
    private String town;

    /**
     * 街道
     */
    @TableField(value = "street")
    private String street;

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