package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateRange;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.List;

/**
 * 日期范围
 * @author lixuan
 * @Date 2024/12/19 14:26
 */
public class Main9 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // 创建日期范围生成器
        DateTime start = DateUtil.parse("2021-01-31");
        DateTime end = DateUtil.parse("2021-03-31");
        DateRange range = DateUtil.range(start, end, DateField.MONTH);
        range.forEach(System.out::println);

        System.out.println("------------------------");

        // 简单使用
        // 开始时间
        DateRange startRange = DateUtil.range(DateUtil.parse("2017-01-01"), DateUtil.parse("2017-01-31"), DateField.DAY_OF_YEAR);
        startRange.forEach(System.out::println);

        System.out.println("------------------------");

        // 结束时间
        DateRange endRange = DateUtil.range(DateUtil.parse("2017-01-31"), DateUtil.parse("2017-02-02"), DateField.DAY_OF_YEAR);
        endRange.forEach(System.out::println);

        System.out.println("------------------------");

        // 交集 返回 [2017-01-31 00:00:00]
        List<DateTime> dateTimes = DateUtil.rangeContains(startRange, endRange);
        System.out.println("test1--dateTimes==>"+dateTimes);
        // 差集 返回 [2017-02-01 00:00:00, 2017-02-02 00:00:00]
        List<DateTime> dateNotTimes = DateUtil.rangeNotContains(startRange,endRange);
        System.out.println("test1--dateNotTimes==>"+dateNotTimes);
        // 区间 返回[2017-01-01 00:00:00, 2017-01-02 00:00:00, 2017-01-03 00:00:00]
        List<DateTime> rangeToList = DateUtil.rangeToList(DateUtil.parse("2017-01-01"), DateUtil.parse("2017-01-03"), DateField.DAY_OF_YEAR);
        System.out.println("test1--rangeToList==>"+rangeToList);
    }
}
