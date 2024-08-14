package com.cloud.service.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.service.domain.entity.OrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 详情表DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "订单表DTO")
public class OrderFormDTO {
    @Schema(description = "收货地址id")
    private Long addressId;
    @Schema(description = "支付类型")
    private Integer paymentType;
    @Schema(description = "下单商品列表")
    private List<OrderDetailDTO> details;
}
