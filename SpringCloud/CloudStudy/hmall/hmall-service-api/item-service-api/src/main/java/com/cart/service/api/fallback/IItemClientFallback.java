package com.cart.service.api.fallback;

import com.cart.service.api.domain.dto.ItemDTO;
import com.cart.service.api.feign.ItemClient;
import com.tarde.service.api.domain.dto.OrderDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author lixuan
 * @Date 2024/8/16 11:58
 */
@Slf4j
@Component
public class IItemClientFallback implements FallbackFactory<ItemClient> {

    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("查询商品失败",cause);
                return List.of();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                log.error("扣减库存失败",cause);
            }
        };
    }
}
