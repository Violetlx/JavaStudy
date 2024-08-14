package com.cloud.service.domain.vo;

import com.cloud.service.domain.entity.OrderLogisticsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单日志表VO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderLogisticsVO extends OrderLogisticsEntity {

    @Serial
    private static final long serialVersionUID = 1L;
}
