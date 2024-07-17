package com.javase.day3.entity;

/**
 * 研究者(接口)
 * @author lixuan
 * @Date 2024/5/30 12:06
 */
public class Researcher extends Person implements Study{
    public Researcher(String name, int age, String sex) {
        super(name, age, sex);
    }
    @Override
    public void study() {
        System.out.println("科研人员正在科研");
    }
}
