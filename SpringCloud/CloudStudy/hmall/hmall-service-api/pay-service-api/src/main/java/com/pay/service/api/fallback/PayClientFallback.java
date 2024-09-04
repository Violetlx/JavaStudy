package com.pay.service.api.fallback;

import com.pay.service.api.dto.PayOrderDTO;
import com.pay.service.api.feign.PayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author lixuan
 * @Date 2024/9/4 16:46
 */
@Slf4j
public class PayClientFallback implements FallbackFactory<PayClient> {
    @Override
    public PayClient create(Throwable cause) {
        return new PayClient() {
            @Override
            public PayOrderDTO queryPayOrderByBizOrderNo(Long id) {
                return null;
            }
        };
    }
}
