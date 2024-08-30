package com.cart.service.api.config;

import com.cart.service.api.fallback.IItemClientFallback;
import org.springframework.context.annotation.Bean;

/**
 * @author lixuan
 * @Date 2024/8/29 16:59
 */
public class ItemConfig {

    @Bean
    public IItemClientFallback itemClientFallback(){
        return new IItemClientFallback();
    }
}
