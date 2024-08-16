package com.cart.service.api.feign;


import com.cart.service.api.domain.dto.ItemDTO;
import com.cart.service.api.fallback.IItemClientFallback;
import com.tarde.service.api.domain.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * 远程调用Item服务
 * @author lixuan
 * @Date 2024/8/16 11:06
 */
@FeignClient(value = "item-service", fallback = IItemClientFallback.class)
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);

    @PutMapping("/items/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}
