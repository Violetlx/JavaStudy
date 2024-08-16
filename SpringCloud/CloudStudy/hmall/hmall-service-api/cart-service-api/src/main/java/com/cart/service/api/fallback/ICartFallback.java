package com.cart.service.api.fallback;

import com.cart.service.api.feign.CartClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * @author lixuan
 * @Date 2024/8/16 15:20
 */
public class ICartFallback implements CartClient {
    private static final Logger log = LoggerFactory.getLogger(ICartFallback.class);

    @Override
    public void removeByItemIds(Collection<Long> ids) {
        log.error("删除购物车商品失败");
    }
}
