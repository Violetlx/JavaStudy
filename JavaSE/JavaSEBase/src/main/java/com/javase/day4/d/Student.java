package com.javase.day4.d;

/**
 * 学生抽象类(匿名内部类)
 * @author lixuan
 * @Date 2024/6/13 14:16
 */
public abstract class Student {
    public  String name;
    public Student(String name){
        this.name = name;
    }
    public abstract void test();
}
