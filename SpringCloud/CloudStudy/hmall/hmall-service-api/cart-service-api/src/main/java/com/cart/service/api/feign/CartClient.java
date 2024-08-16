package com.cart.service.api.feign;

import com.cart.service.api.fallback.ICartFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * @author lixuan
 * @Date 2024/8/16 15:19
 */
@FeignClient(value = "cart-service", fallback = ICartFallback.class)
public interface CartClient {

    @DeleteMapping("carts")
    void removeByItemIds(@RequestParam("ids") Collection<Long> ids);
}
