package com.hutool.core.date.datetime;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;

import java.util.Date;

/**
 * 新建对象
 * @author lixuan
 * @Date 2024/12/19 14:55
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.新建对象
     */
    public static void test1(){
        Date date = new Date();

        //new方式创建
        DateTime time = new DateTime(date);
        Console.error("test1--time==>"+time);
        System.out.println("test1--time==>"+time);

        //of方式创建
        DateTime dt = DateTime.of(date);
        System.out.println("test1--dt==>"+dt);
        DateTime now = DateTime.now();
        System.out.println("test1--now==>"+now);

    }
}
