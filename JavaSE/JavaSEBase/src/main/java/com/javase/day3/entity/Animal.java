package com.javase.day3.entity;

import lombok.Data;

/**
 * 动物类(权限控制)
 * @author lixuan
 * @Date 2024/5/29 11:36
 */
@Data
public class Animal {
    /**
     * 这里我们用test方法的返回值作为变量的初始值，便于观察
     */
    String name = test();
    int age;
    String sex;

    {
        System.out.println("我是普通代码块");
    }

    public Animal(){
        System.out.println("我是构造方法");
    }

    String test(){
        System.out.println("我是成员变量初始化");
        return "小明";
    }

    /**
     * 这里我们用init静态方法的返回值作为变量的初始值，便于观察
     */
    static String info = init();

    static {
        System.out.println("我是静态代码块");
    }

    static String init(){
        System.out.println("我是静态变量初始化");
        return "test";
    }
}
