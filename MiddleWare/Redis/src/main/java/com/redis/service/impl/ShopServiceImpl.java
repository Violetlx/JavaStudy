package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.Shop;
import com.redis.service.IShopService;
import com.redis.mapper.ShopMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_shop】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
    implements IShopService {

}




