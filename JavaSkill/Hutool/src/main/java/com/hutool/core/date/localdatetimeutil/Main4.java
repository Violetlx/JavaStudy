package com.hutool.core.date.localdatetimeutil;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 日期偏移
 * @author lixuan
 * @Date 2024/12/19 17:15
 */
public class Main4 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.日期偏移
     */
    public static void test1(){
        final LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // 增加一天
        // "2020-01-24T12:23:56"
        LocalDateTime offset = LocalDateTimeUtil.offset(localDateTime, 1, ChronoUnit.DAYS);
        System.out.println("test1--offset==>"+offset);
    }

    /**
     * 2.如果是减少时间，offset第二个参数传负数即可
     */
    public static void test2(){
        final LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // "2020-01-22T12:23:56"
        LocalDateTime offset = LocalDateTimeUtil.offset(localDateTime, -1, ChronoUnit.DAYS);
        System.out.println("test2--offset==>"+offset);
    }
}
