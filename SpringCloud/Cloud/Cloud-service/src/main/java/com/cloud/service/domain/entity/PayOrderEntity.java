package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 支付订单
 * @TableName pay_order
 */
@TableName(value ="pay_order")
@Data
public class PayOrderEntity implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务订单号
     */
    @TableField(value = "biz_order_no")
    private Long bizOrderNo;

    /**
     * 支付单号
     */
    @TableField(value = "pay_order_no")
    private Long payOrderNo;

    /**
     * 支付用户id
     */
    @TableField(value = "biz_user_id")
    private Long bizUserId;

    /**
     * 支付渠道编码
     */
    @TableField(value = "pay_channel_code")
    private String payChannelCode;

    /**
     * 支付金额，单位分
     */
    @TableField(value = "amount")
    private Integer amount;

    /**
     * 支付类型，1：h5,2:小程序，3：公众号，4：扫码，5：余额支付
     */
    @TableField(value = "pay_type")
    private Integer payType;

    /**
     * 支付状态，0：待提交，1:待支付，2：支付超时或取消，3：支付成功
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 拓展字段，用于传递不同渠道单独处理的字段
     */
    @TableField(value = "expand_json")
    private String expandJson;

    /**
     * 第三方返回业务码
     */
    @TableField(value = "result_code")
    private String resultCode;

    /**
     * 第三方返回提示信息
     */
    @TableField(value = "result_msg")
    private String resultMsg;

    /**
     * 支付成功时间
     */
    @TableField(value = "pay_success_time")
    private Date paySuccessTime;

    /**
     * 支付超时时间
     */
    @TableField(value = "pay_over_time")
    private Date payOverTime;

    /**
     * 支付二维码链接
     */
    @TableField(value = "qr_code_url")
    private String qrCodeUrl;

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

    /**
     * 创建人
     */
    @TableField(value = "creater")
    private Long creater;

    /**
     * 更新人
     */
    @TableField(value = "updater")
    private Long updater;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_delete")
    private Boolean isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}