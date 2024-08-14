package com.cloud.service.domain.dto;

import com.cloud.service.domain.entity.PayOrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 支付订单表DTO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "支付订单表DTO")
public class PayOrderFormDTO {
    @Schema(description = "支付订单id不能为空")
    @NotNull(message = "支付订单id不能为空")
    private Long id;
    @Schema(description = "支付密码")
    @NotNull(message = "支付密码")
    private String pw;
}
