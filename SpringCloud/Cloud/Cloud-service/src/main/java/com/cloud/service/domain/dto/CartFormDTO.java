package com.cloud.service.domain.dto;

import com.cloud.service.domain.entity.CartEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单详情表DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "订单详情表DTO")
public class CartFormDTO {
    @Schema(description = "商品id")
    private Long itemId;
    @Schema(description = "商品标题")
    private String name;
    @Schema(description = "商品动态属性键值集")
    private String spec;
    @Schema(description = "价格,单位：分")
    private Integer price;
    @Schema(description = "商品图片")
    private String image;
}
