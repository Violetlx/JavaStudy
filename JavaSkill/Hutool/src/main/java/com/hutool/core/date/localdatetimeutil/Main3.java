package com.hutool.core.date.localdatetimeutil;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;

/**
 * 日期格式化
 * @author lixuan
 * @Date 2024/12/19 17:09
 */
public class Main3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.日期格式化
     */
    public static void test1() {
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // "2020-01-23 12:23:56"
        String format = LocalDateTimeUtil.format(localDateTime, DatePattern.NORM_DATETIME_PATTERN);
        System.out.println("test1--format==>"+format);

    }
}
