package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 日期时间差
 * @author lixuan
 * @Date 2024/12/19 12:29
 */
public class Main6 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.日期时间差
     */
    public static void test1() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        System.out.println("test1--date1==>"+date1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        System.out.println("test1--date2==>"+date2);

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println("test1--betweenDay==>"+betweenDay);

    }
}
