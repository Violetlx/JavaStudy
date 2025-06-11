package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 日期时间偏移
 * @author lixuan
 * @Date 2024/12/19 12:17
 */
public class Main5 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的
     */
    public static void test1(){
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println("test1--newDate==>"+newDate);

        //常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);
        System.out.println("test1--newDate2==>"+newDate2);

        //常用偏移，结果：2017-03-01 19:33:23
        DateTime newDate3 = DateUtil.offsetHour(date, -3);
        System.out.println("test1--newDate3==>"+newDate3);

    }

    /**
     * 2.针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）
     */
    public static void test2(){
        //昨天
        DateTime yesterday = DateUtil.yesterday();
        System.out.println("test2--yesterday==>"+yesterday);
        //明天
        DateTime tomorrow = DateUtil.tomorrow();
        System.out.println("test2--tomorrow==>"+tomorrow);
        //上周
        DateTime lastWeek = DateUtil.lastWeek();
        System.out.println("test2--lastWeek==>"+lastWeek);
        //下周
        DateTime nextWeek = DateUtil.nextWeek();
        System.out.println("test2--nextWeek==>"+nextWeek);
        //上个月
        DateTime lastMonth = DateUtil.lastMonth();
        System.out.println("test2--lastMonth==>"+lastMonth);
        //下个月
        DateTime nextMonth = DateUtil.nextMonth();
        System.out.println("test2--nextMonth==>"+nextMonth);
    }
}
