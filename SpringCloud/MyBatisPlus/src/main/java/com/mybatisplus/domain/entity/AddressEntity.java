package com.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址表
 * @author lixuan
 * @TableName address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="address")
@Schema(description = "地址表")
public class AddressEntity implements Serializable {
    /**
     * 
     */
    @Schema(description = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @TableField(value = "user_id")
    private Long userId;

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
     * 县/区
     */
    @Schema(description = "县/区")
    @TableField(value = "town")
    private String town;

    /**
     * 手机
     */
    @Schema(description = "手机")
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    @TableField(value = "street")
    private String street;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    @TableField(value = "contact")
    private String contact;

    /**
     * 是否是默认 1默认 0否
     */
    @Schema(description = "是否是默认 1默认 0否")
    @TableField(value = "is_default")
    private Boolean isDefault;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField(value = "notes")
    private String notes;

    /**
     * 逻辑删除
     */
    @Schema(description = "逻辑删除")
    @TableField(value = "deleted")
    private Boolean deleted;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}