package com.hmall.trade.listener;

import com.hmall.trade.constants.MQConstants;
import com.hmall.trade.service.IOrderService;
import com.pay.service.api.dto.PayOrderDTO;
import com.pay.service.api.feign.PayClient;
import com.tarde.service.api.domain.po.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lixuan
 * @Date 2024/9/4 16:36
 */
@Component
@RequiredArgsConstructor
public class OrderDelayMessageListener {

    private final IOrderService orderService;
    private final PayClient payClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = MQConstants.DELAY_ORDER_QUEUE_NAME),
            exchange = @Exchange(name = MQConstants.DELAY_EXCHANGE_NAME, delayed = "true"),
            key = MQConstants.DELAY_ORDER_KEY
    ))
    public void listenDelayMessage(Long orderId) {
        // 1.查询订单
        Order order = orderService.getById(orderId);
        // 2.检测订单状态，判断是否已支付
        if (order == null || order.getStatus() != 1) {
            // 订单不存在，或者已支付
            return;
        }
        // 3.未支付，需要查询支付流水状态
        PayOrderDTO payOrder = payClient.queryPayOrderByBizOrderNo(orderId);
        // 4.判断是否支付
        if (payOrder == null || payOrder.getStatus() == 3) {
            // 4.1.已支付，标记订单为已支付
            orderService.markOrderPaySuccess(orderId);
        } else {
            // 4.2.未支付，取消订单，恢复库存
            orderService.cancleOrder(orderId);
        }

    }
}
