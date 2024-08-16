package com.user.service.api.feign;

import com.user.service.api.fallback.IUserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lixuan
 * @Date 2024/8/16 15:40
 */
@FeignClient(value = "user-service", fallback = IUserClientFallback.class)
public interface UserClient {

    @PutMapping("/users/money/deduct")
    void deductMoney(@RequestParam("pw") String pw, @RequestParam("amount") Integer amount);
}
