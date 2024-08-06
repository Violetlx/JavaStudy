package com.redis.service;

import com.redis.domain.dto.Result;
import com.redis.domain.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【tb_shop_type】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IShopTypeService extends IService<ShopType> {

    Result cacheShopTypeList();

    Result queryById(Long id);
}
