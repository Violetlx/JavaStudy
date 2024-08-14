package com.cloud.service.controller;

import com.cloudcommon.exception.BizIllegalException;
import com.cloud.service.domain.dto.PayApplyDTO;
import com.cloud.service.domain.dto.PayOrderFormDTO;
import com.cloud.service.enums.PayType;
import com.cloud.service.service.IPayOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 支付相关接口
 * @author lixuan
 */
@RestController
@RequestMapping("pay-orders")
@RequiredArgsConstructor
@Tag(name = "支付相关接口")
public class PayController {

    private final IPayOrderService payOrderService;

    @PostMapping
    @Operation(summary = "生成支付单")
    public String applyPayOrder(@RequestBody PayApplyDTO applyDTO){
        if(!PayType.BALANCE.equalsValue(applyDTO.getPayType())){
            // 目前只支持余额支付
            throw new BizIllegalException("抱歉，目前只支持余额支付");
        }
        return payOrderService.applyPayOrder(applyDTO);
    }

    @PostMapping("{id}")
    @Operation(summary = "尝试基于用户余额支付")
    public void tryPayOrderByBalance(@Parameter(description = "支付订单id") @PathVariable("id") Long id, @RequestBody PayOrderFormDTO payOrderFormDTO){
        payOrderFormDTO.setId(id);
        payOrderService.tryPayOrderByBalance(payOrderFormDTO);
    }
}
