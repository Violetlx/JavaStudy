package com.hutool.core.date.datetime;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.Quarter;

/**
 * 使用对象
 * @author lixuan
 * @Date 2024/12/19 15:00
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.使用对象
     */
    public static void test1(){
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);

        //年，结果：2017
        int year = dateTime.year();
        System.out.println("test1--year==>"+year);

        //季度（非季节），结果：Q1
        Quarter quarter = dateTime.quarterEnum();
        System.out.println("test1--quarter==>"+quarter);

        //月份，结果：Month.JANUARY
        Month month = dateTime.monthEnum();
        System.out.println("test1--month==>"+month);

        //日，结果：5
        int day = dateTime.dayOfMonth();
        System.out.println("test1--day==>"+day);
    }
}
