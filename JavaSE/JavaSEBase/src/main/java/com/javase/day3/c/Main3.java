package com.javase.day3.c;

import com.javase.day3.entity.Worker;

/**
 * Object类
 * @author lixuan
 * @Date 2024/5/29 15:07
 */
public class Main3 {
    public static void main(String[] args) {
        //顶层Object类  实际上所有类都默认继承自Object类，除非手动指定继承的类型，但是依然改变不了最顶层的父类是Object类。所有类中都包含Object类中的方法
        Worker worker = new Worker("李四", 20, "男");
        //Object object = new Object();
    }
}
