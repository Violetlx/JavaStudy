package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUtil;

/**
 * 其他
 * @author lixuan
 * @Date 2024/12/19 14:32
 */
public class Main10 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.年龄
     */
    public static void test1() {
        int age = DateUtil.ageOfNow("1990-01-30");
        System.out.println("test--age==>"+age);
    }

    /**
     * 2.是否闰年
     */
    public static void test2() {
        boolean leapYear = DateUtil.isLeapYear(2017);
        System.out.println("test--leapYear==>"+leapYear);
    }
}
