package com.cloud.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName address
 */
@TableName(value ="address")
@Data
public class AddressEntity implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

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
     * 县/区
     */
    @TableField(value = "town")
    private String town;

    /**
     * 手机
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 详细地址
     */
    @TableField(value = "street")
    private String street;

    /**
     * 联系人
     */
    @TableField(value = "contact")
    private String contact;

    /**
     * 是否是默认 1默认 0否
     */
    @TableField(value = "is_default")
    private String isDefault;

    /**
     * 备注
     */
    @TableField(value = "notes")
    private String notes;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}