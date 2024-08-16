package com.tarde.service.api.fallback;

import com.tarde.service.api.domain.po.Order;
import com.tarde.service.api.feign.OrderClient;

/**
 * @author lixuan
 * @Date 2024/8/16 15:44
 */
public class IOrderClientFallback implements OrderClient {
    @Override
    public boolean updateById(Order order) {
        return false;
    }
}
