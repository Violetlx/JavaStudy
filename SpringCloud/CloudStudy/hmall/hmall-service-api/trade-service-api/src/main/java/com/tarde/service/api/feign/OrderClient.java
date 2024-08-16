package com.tarde.service.api.feign;

import com.tarde.service.api.domain.po.Order;
import com.tarde.service.api.fallback.IOrderClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lixuan
 * @Date 2024/8/16 15:44
 */
@FeignClient(value = "trade-service", fallback = IOrderClientFallback.class)
public interface OrderClient {
    @PutMapping("/orders/update")
    boolean updateById(@RequestBody Order order);
}
