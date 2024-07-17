package com.javase.day3.entity;

import lombok.Data;

/**
 * 狗类(类的封装)
 * @author lixuan
 * @Date 2024/5/29 14:27
 */
@Data
public class Dog {
    String name;
    int age;
    String sex;

    private Dog() {  //不允许外部使用new关键字来创建对象
    }

    public static Dog getInstance() {  //而是需要使用我们的独特方法来生成对象并返回
        return new Dog();
    }

}
