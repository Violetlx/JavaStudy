package com.cloud.service.domain.dto;

import com.cloud.service.domain.entity.AddressEntity;
import com.cloud.service.domain.entity.OrderDetailEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单详情DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "订单详情DTO")
public class OrderDetailDTO {

    @Schema(description = "商品id")
    private Long itemId;
    @Schema(description = "商品购买数量")
    private Integer num;
}
