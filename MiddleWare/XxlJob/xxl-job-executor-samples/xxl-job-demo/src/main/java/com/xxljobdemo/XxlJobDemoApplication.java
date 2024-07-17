package com.xxljobdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 1045754
 */
@SpringBootApplication
@MapperScan("com.xxljobdemo.mapper")
public class XxlJobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobDemoApplication.class, args);
    }

}
