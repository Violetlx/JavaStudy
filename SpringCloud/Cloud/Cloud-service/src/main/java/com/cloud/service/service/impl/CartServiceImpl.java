package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.CartEntity;
import com.cloud.service.service.ICartService;
import com.cloud.service.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【cart(订单详情表)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, CartEntity>
    implements ICartService {

}




