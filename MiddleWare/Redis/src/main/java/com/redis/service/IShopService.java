package com.redis.service;

import com.redis.domain.dto.Result;
import com.redis.domain.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【tb_shop】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IShopService extends IService<Shop> {

    Result queryById(Long id);

    Result update(Shop shop);

    Result queryShopByType(Integer typeId, Integer current, Double x, Double y);
}
