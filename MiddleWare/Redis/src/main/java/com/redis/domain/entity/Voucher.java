package com.redis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 优惠券表
 * @author lixuan
 * @TableName tb_voucher
 */
@TableName(value ="tb_voucher")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Voucher implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 代金券标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 副标题
     */
    @TableField(value = "sub_title")
    private String subTitle;

    /**
     * 使用规则
     */
    @TableField(value = "rules")
    private String rules;

    /**
     * 支付金额，单位是分。例如200代表2元
     */
    @TableField(value = "pay_value")
    private Long payValue;

    /**
     * 抵扣金额，单位是分。例如200代表2元
     */
    @TableField(value = "actual_value")
    private Long actualValue;

    /**
     * 0,普通券；1,秒杀券
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 1,上架; 2,下架; 3,过期
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 库存
     */
    @TableField(exist = false)
    private Integer stock;

    /**
     * 生效时间
     */
    @TableField(exist = false)
    private LocalDateTime beginTime;

    /**
     * 失效时间
     */
    @TableField(exist = false)
    private LocalDateTime endTime;

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