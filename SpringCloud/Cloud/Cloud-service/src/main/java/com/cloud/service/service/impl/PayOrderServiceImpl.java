package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.PayOrderEntity;
import com.cloud.service.service.IPayOrderService;
import com.cloud.service.mapper.PayOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【pay_order(支付订单)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrderEntity>
    implements IPayOrderService {

}




