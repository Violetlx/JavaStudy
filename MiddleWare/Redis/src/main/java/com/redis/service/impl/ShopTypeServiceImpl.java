package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.ShopType;
import com.redis.service.IShopTypeService;
import com.redis.mapper.ShopTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_shop_type】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType>
    implements IShopTypeService {

}




