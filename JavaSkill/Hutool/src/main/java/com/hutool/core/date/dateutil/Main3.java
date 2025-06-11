package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;

import java.util.Date;

/**
 * 获取Date对象的某个部分
 * @author lixuan
 * @Date 2024/12/19 12:05
 */
public class Main3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.获取Date对象的某个部分
     */
    public static void test1(){
        Date date = DateUtil.date();
        //获得年的部分
        int year = DateUtil.year(date);
        System.out.println("test1--year==>"+year);
        //获得月份，从0开始计数
        int month = DateUtil.month(date);
        System.out.println("test1--month==>"+month);
        //获得月份枚举
        Month monthEnum = DateUtil.monthEnum(date);
        System.out.println("test1--monthEnum==>"+monthEnum);
        //.....
    }
}
