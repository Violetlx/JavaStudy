package com.cloud.service.service;

import com.cloud.service.domain.dto.PayApplyDTO;
import com.cloud.service.domain.dto.PayOrderFormDTO;
import com.cloud.service.domain.entity.PayOrderEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【pay_order(支付订单)】的数据库操作Service
* @createDate 2024-08-12 15:34:29
*/
public interface IPayOrderService extends IService<PayOrderEntity> {

    String applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
