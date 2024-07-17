package com.javase.day3.entity;

import lombok.Data;

/**
 * 学生类(类的继承)
 * @author lixuan
 * @Date 2024/5/29 14:47
 */
@Data
public class Student extends Person {

    /**
     * 学习
     */
    public void study() {
        //可以直接访问父类中定义的name属性
        System.out.println("我的名字是"+name+",我在学习！");
    }
}
