package com.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页拦截器
 * @author lixuan
 * @Date 2024/8/8 9:36
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 定义一个mybatisPlus的拦截器 再 add一个分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.初始化核心插件
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //2.添加分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
