package com.hutool.core.date.localdatetimeutil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import java.time.LocalDateTime;

/**
 * 日期转换
 * @author lixuan
 * @Date 2024/12/19 16:34
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.日期转换
     */
    public static void test1() {
        String dateStr = "2020-01-23T12:23:56";
        DateTime dt = DateUtil.parse(dateStr);
        System.out.println("test1--dt==>"+dt);

        // Date对象转换为LocalDateTime
        LocalDateTime of = LocalDateTimeUtil.of(dt);
        System.out.println("test1--of==>"+of);

        // 时间戳转换为LocalDateTime
        of = LocalDateTimeUtil.ofUTC(dt.getTime());
        System.out.println("test1--of==>"+of);
    }
}
