package com.user.service.api.fallback;

import com.user.service.api.feign.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lixuan
 * @Date 2024/8/16 15:41
 */
public class IUserClientFallback implements UserClient {
    private static final Logger log = LoggerFactory.getLogger(IUserClientFallback.class);

    @Override
    public void deductMoney(String pw, Integer amount) {
        log.error("扣减余额失败");
    }
}
