package com.cloud.service.controller;

import com.cloud.service.domain.dto.OrderFormDTO;
import com.cloudcommon.utils.BeanUtils;
import com.cloud.service.domain.vo.OrderVO;
import com.cloud.service.service.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;


/**
 * 订单管理接口
 * @author lixuan
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "订单管理接口")
public class OrderController {
    private final IOrderService orderService;

    @GetMapping("{id}")
    @Operation(summary = "根据id查询订单")
    public OrderVO queryOrderById(@Param ("订单id")@PathVariable("id") Long orderId) {
        return BeanUtils.copyBean(orderService.getById(orderId), OrderVO.class);
    }

    @PostMapping
    @Operation(summary = "创建订单")
    public Long createOrder(@RequestBody OrderFormDTO orderFormDTO){
        return orderService.createOrder(orderFormDTO);
    }


    @PutMapping("/{orderId}")
    @Operation(summary = "标记订单已支付")
    public void markOrderPaySuccess(@PathVariable("orderId") Long orderId) {
        orderService.markOrderPaySuccess(orderId);
    }
}
