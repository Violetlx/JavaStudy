package com.hmall.trade.listener;

import com.hmall.trade.service.IOrderService;
import com.tarde.service.api.domain.po.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 支付状态监听
 * @author lixuan
 * @Date 2024/9/2 15:10
 */
@Component
@RequiredArgsConstructor
public class PayStatusListener {

    private final IOrderService orderService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "trade.pay.success.queue", durable = "true"),
            exchange = @Exchange(name = "pay.direct"),
            key = "pay.success"
    ))
    public void listenPaySuccess(Long orderId){
        // 1.查询订单
        Order order = orderService.getById(orderId);
        // 2.判断订单状态,是否为未支付
        if (order == null || order.getStatus() != 1) {
            // 不做处理
            return;
        }
        // 3.标记订单为已支付
        orderService.markOrderPaySuccess(orderId);
    }
}
