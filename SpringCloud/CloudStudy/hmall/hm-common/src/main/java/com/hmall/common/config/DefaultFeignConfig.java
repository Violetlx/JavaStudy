package com.hmall.common.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author lixuan
 * @Date 2024/8/16 12:15
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
