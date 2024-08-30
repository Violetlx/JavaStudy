package com.xxljobdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author lixuan
 * @Date 2024/7/17 20:23
 */
@Service
public class HelloService {
    public void methodA(){
        System.out.println("执行MethodA的方法");
    }
    public void methodB(){
        System.out.println("执行MethodB的方法");
    }
}