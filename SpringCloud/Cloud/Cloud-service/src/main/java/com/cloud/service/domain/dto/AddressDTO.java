package com.cloud.service.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;

/**
 * 地址表DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "地址表DTO")
public class AddressDTO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "省")
    private String province;
    @Schema(description = "市")
    private String city;
    @Schema(description = "县/区")
    private String town;
    @Schema(description = "手机")
    private String mobile;
    @Schema(description = "详细地址")
    private String street;
    @Schema(description = "联系人")
    private String contact;
    @Schema(description = "是否是默认 1默认 0否")
    private Integer isDefault;
    @Schema(description = "备注")
    private String notes;
}
