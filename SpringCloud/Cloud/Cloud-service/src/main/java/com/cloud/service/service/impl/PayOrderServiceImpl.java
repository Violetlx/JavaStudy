package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.dto.PayApplyDTO;
import com.cloud.service.domain.dto.PayOrderFormDTO;
import com.cloud.service.domain.entity.OrderEntity;
import com.cloud.service.domain.entity.PayOrderEntity;
import com.cloud.service.enums.PayStatus;
import com.cloud.service.service.IOrderService;
import com.cloud.service.service.IPayOrderService;
import com.cloud.service.mapper.PayOrderMapper;
import com.cloud.service.service.IUserService;
import com.cloudcommon.exception.BizIllegalException;
import com.cloudcommon.utils.BeanUtils;
import com.cloudcommon.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
* @author 1045754
* @description 针对表【pay_order(支付订单)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
@RequiredArgsConstructor
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrderEntity>
    implements IPayOrderService {

    private final IUserService userService;

    private final IOrderService orderService;


    @Override
    public String applyPayOrder(PayApplyDTO applyDTO) {
        // 1.幂等性校验
        PayOrderEntity payOrder = checkIdempotent(applyDTO);
        // 2.返回结果
        return payOrder.getId().toString();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO) {
        // 1.查询支付单
        PayOrderEntity po = getById(payOrderFormDTO.getId());
        // 2.判断状态
        if(!PayStatus.WAIT_BUYER_PAY.equalsValue(po.getStatus())){
            // 订单不是未支付，状态异常
            throw new BizIllegalException("交易已支付或关闭！");
        }
        // 3.尝试扣减余额
        userService.deductMoney(payOrderFormDTO.getPw(), po.getAmount());
        // 4.修改支付单状态
        boolean success = markPayOrderSuccess(payOrderFormDTO.getId(), LocalDateTime.now());
        if (!success) {
            throw new BizIllegalException("交易已支付或关闭！");
        }
        // 5.修改订单状态
        OrderEntity order = new OrderEntity();
        order.setId(po.getBizOrderNo());
        order.setStatus(2);
        order.setPayTime(new Date());
        orderService.updateById(order);
    }

    private PayOrderEntity checkIdempotent(PayApplyDTO applyDTO) {
        // 1.首先查询支付单
        PayOrderEntity oldOrder = queryByBizOrderNo(applyDTO.getBizOrderNo());
        // 2.判断是否存在
        if (oldOrder == null) {
            // 不存在支付单，说明是第一次，写入新的支付单并返回
            PayOrderEntity payOrder = buildPayOrder(applyDTO);
            payOrder.setPayOrderNo(IdWorker.getId());
            save(payOrder);
            return payOrder;
        }
        // 3.旧单已经存在，判断是否支付成功
        if (PayStatus.TRADE_SUCCESS.equalsValue(oldOrder.getStatus())) {
            // 已经支付成功，抛出异常
            throw new BizIllegalException("订单已经支付！");
        }
        // 4.旧单已经存在，判断是否已经关闭
        if (PayStatus.TRADE_CLOSED.equalsValue(oldOrder.getStatus())) {
            // 已经关闭，抛出异常
            throw new BizIllegalException("订单已关闭");
        }
        // 5.旧单已经存在，判断支付渠道是否一致
        if (!StringUtils.equals(oldOrder.getPayChannelCode(), applyDTO.getPayChannelCode())) {
            // 支付渠道不一致，需要重置数据，然后重新申请支付单
            PayOrderEntity payOrder = buildPayOrder(applyDTO);
            payOrder.setId(oldOrder.getId());
            payOrder.setQrCodeUrl("");
            updateById(payOrder);
            payOrder.setPayOrderNo(oldOrder.getPayOrderNo());
            return payOrder;
        }
        // 6.旧单已经存在，且可能是未支付或未提交，且支付渠道一致，直接返回旧数据
        return oldOrder;
    }

    public PayOrderEntity queryByBizOrderNo(Long bizOrderNo) {
        return lambdaQuery()
                .eq(PayOrderEntity::getBizOrderNo, bizOrderNo)
                .one();
    }

    private PayOrderEntity buildPayOrder(PayApplyDTO payApplyDTO) {
        // 1.数据转换
        PayOrderEntity payOrder = BeanUtils.toBean(payApplyDTO, PayOrderEntity.class);
        // 2.初始化数据
        LocalDateTime futureTime = LocalDateTime.now().plusMinutes(120L);
        Date date = Date.from(futureTime.atZone(ZoneId.systemDefault()).toInstant());
        payOrder.setPayOverTime(date);
        payOrder.setStatus(PayStatus.WAIT_BUYER_PAY.getValue());
        payOrder.setBizUserId(UserContext.getUser());
        return payOrder;
    }

    public boolean markPayOrderSuccess(Long id, LocalDateTime successTime) {
        return lambdaUpdate()
                .set(PayOrderEntity::getStatus, PayStatus.TRADE_SUCCESS.getValue())
                .set(PayOrderEntity::getPaySuccessTime, successTime)
                .eq(PayOrderEntity::getId, id)
                // 支付状态的乐观锁判断
                .in(PayOrderEntity::getStatus, PayStatus.NOT_COMMIT.getValue(), PayStatus.WAIT_BUYER_PAY.getValue())
                .update();
    }

}




