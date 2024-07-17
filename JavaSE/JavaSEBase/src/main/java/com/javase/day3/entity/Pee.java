package com.javase.day3.entity;

/**
 * 宠物类(抽象类)
 * @author lixuan
 * @Date 2024/5/30 11:17
 */
public abstract class Pee {
    /**
     * 大体内容其实普通类差不多
     */
    protected String name;
    protected int age;
    protected String sex;
    protected String profession;

    protected Pee(String name, int age, String sex, String profession) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.profession = profession;
    }

    /**
     * 抽象类中可以具有抽象方法，也就是说这个方法只有定义，没有方法体
     */
    public abstract void exam();
}
