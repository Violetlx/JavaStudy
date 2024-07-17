package com.javase.day3.a;

import com.javase.day3.entity.Person;

/**
 * 构造方法
 * @author lixuan
 * @Date 2024/5/29 10:46
 */
public class Main5 {
    public static void main(String[] args) {
        //调用自己定义的带三个参数的构造方法
        Person person = new Person("小明",18,"男");
        System.out.println(person);


        /*
         * public class Person {
         *     String name = "未知";   //直接赋值，那么对象构造好之后，属性默认就是这个值
         *     int age = 10;
         *     String sex = "男";
         * }
         */
    }
}
