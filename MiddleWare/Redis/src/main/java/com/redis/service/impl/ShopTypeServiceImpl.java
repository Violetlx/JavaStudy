package com.redis.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.dto.Result;
import com.redis.domain.entity.ShopType;
import com.redis.service.IShopTypeService;
import com.redis.mapper.ShopTypeMapper;
import com.redis.utils.CacheClient;
import jakarta.annotation.Resource;
import jodd.util.StringUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.redis.utils.RedisConstants.*;

/**
* @author 1045754
* @description 针对表【tb_shop_type】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType>
    implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    @Override
    public Result cacheShopTypeList() {
        //1、从redis中查询商铺类型列表
        List<String> shopTypeJsonList = stringRedisTemplate.opsForList().range(CACHE_SHOP_TYPE_KEY, 0, -1);

        //2、判断是否存在
        if (!Objects.requireNonNull(shopTypeJsonList).isEmpty()) {
            //3、存在，直接返回
            //转为list
            // 转为 ShopType 列表
            List<ShopType> shopTypeList = shopTypeJsonList.stream()
                    .map(json -> JSONUtil.toBean(json, ShopType.class))
                    .collect(Collectors.toList());
            return Result.ok(shopTypeList);
        }

        //4、不存在，则查询数据库
        List<ShopType> shopTypeList = list();

        //5、判断数据库商铺列表是否为空
        if (shopTypeList.isEmpty()) {
            return Result.fail("商铺类型不存在");
        }

        // 6、存在，写入 Redis
        shopTypeList.forEach(shopType ->
                stringRedisTemplate.opsForList().rightPush(CACHE_SHOP_TYPE_KEY_LIST, JSONUtil.toJsonStr(shopType)));

        //7、返回
        return Result.ok(shopTypeList);
    }

    @Override
    public Result queryById(Long id) {
        //互斥锁解决缓存击穿
        ShopType shopType = cacheClient
                .queryWithMutex(CACHE_SHOP_TYPE_KEY, id, ShopType.class, this::getById, CACHE_SHOP_TTL, TimeUnit.MINUTES);
        if (ObjectUtil.isNull(shopType)) {
            return Result.fail("商铺类型不存在");
        }
        return Result.ok(shopType);
    }
}




