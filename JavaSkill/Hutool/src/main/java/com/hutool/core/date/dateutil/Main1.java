package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * 转换
 * @author lixuan
 * @Date 2024/12/19 11:36
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.Date、long、Calendar 之间的相互转换
     */
    public static void test1(){
        //当前时间
        Date date = DateUtil.date();
        System.out.println("test1--date==>"+date);
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("test1--date2==>"+date2);
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("test1--date3==>"+date3);
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("test1--now==>"+now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();
        System.out.println("test1--today==>"+today);

    }

    /**
     * 2.字符串转化日期
     */
    public static void test2(){
        //字符串转化日期
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println("test2--date==>"+date);

        //自定义日期格式转化
        String dateString = "2017-03-01";
        Date dateTime = DateUtil.parse(dateString, "yyyy-MM-dd");
        System.out.println("test2--dateTime==>"+dateTime);
    }
}
