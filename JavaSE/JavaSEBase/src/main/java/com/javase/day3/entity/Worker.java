package com.javase.day3.entity;

import lombok.Data;

/**
 * 工人类(类的继承)
 * @author lixuan
 * @Date 2024/5/29 14:46
 */
@Data
public class Worker extends Person{
    //子类中同样可以定义name属性

    protected String name;

    public Worker(String name, int age, String sex) {
        super(name, age, sex, "工人");
    }
}
