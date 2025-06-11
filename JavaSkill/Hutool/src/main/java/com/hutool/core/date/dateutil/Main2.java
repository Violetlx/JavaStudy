package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 格式化日期输出
 * @author lixuan
 * @Date 2024/12/19 12:02
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 格式化日期输出
     */
    public static void test1(){
        String dateStr = "2017-03-01 10:11:02";
        Date date = DateUtil.parse(dateStr);
        System.out.println("test1--date==>"+date);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println("test1--format==>"+format);

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);
        System.out.println("test1--formatDate==>"+formatDate);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println("test1--formatDateTime==>"+formatDateTime);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);
        System.out.println("test1--formatTime==>"+formatTime);
    }
}
