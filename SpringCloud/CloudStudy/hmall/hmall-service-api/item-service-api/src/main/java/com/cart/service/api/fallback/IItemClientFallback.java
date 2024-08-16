package com.cart.service.api.fallback;

import com.cart.service.api.domain.dto.ItemDTO;
import com.cart.service.api.feign.ItemClient;
import com.tarde.service.api.domain.dto.OrderDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author lixuan
 * @Date 2024/8/16 11:58
 */
@Component
public class IItemClientFallback implements ItemClient {
    private static final Logger log = LoggerFactory.getLogger(IItemClientFallback.class);

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        return List.of();
    }

    @Override
    public void deductStock(List<OrderDetailDTO> items) {
      log.error("扣减库存失败");
    }
}
