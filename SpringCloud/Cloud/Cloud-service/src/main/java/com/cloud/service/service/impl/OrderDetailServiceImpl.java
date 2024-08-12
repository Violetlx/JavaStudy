package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.OrderDetailEntity;
import com.cloud.service.service.IOrderDetailService;
import com.cloud.service.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【order_detail(订单详情表)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetailEntity>
    implements IOrderDetailService {

}




