package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.OrderEntity;
import com.cloud.service.service.IOrderService;
import com.cloud.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity>
    implements IOrderService {

}




