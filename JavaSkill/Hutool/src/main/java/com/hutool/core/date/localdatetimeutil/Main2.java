package com.hutool.core.date.localdatetimeutil;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;

/**
 * 日期字符串解析
 * @author lixuan
 * @Date 2024/12/19 17:01
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.日期字符串接卸
     */
    public static void test1() {
        // 解析ISO时间
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");
        System.out.println("test1--localDateTime==>"+localDateTime);


        // 解析自定义格式时间
        localDateTime = LocalDateTimeUtil.parse("2020-01-23", DatePattern.NORM_DATE_PATTERN);
        System.out.println("test1--localDateTime==>"+localDateTime);

    }

    /**
     * 2.支持LocalDate
     */
    public static void test2() {
        LocalDate localDate = LocalDateTimeUtil.parseDate("2020-01-23");
        System.out.println("test2--localDate==>"+localDate);

        // 解析日期时间为LocalDate，时间部分舍弃
        localDate = LocalDateTimeUtil.parseDate("2020-01-23T12:23:56", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("test2--localDate==>"+localDate);

    }
}
