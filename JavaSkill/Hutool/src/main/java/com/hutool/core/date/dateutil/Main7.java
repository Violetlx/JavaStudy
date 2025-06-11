package com.hutool.core.date.dateutil;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;

import java.util.Date;

/**
 * 格式化时间差
 * @author lixuan
 * @Date 2024/12/19 14:11
 */
public class Main7 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.格式化时间差
     */
    public static void test1() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:34:23";
        Date date2 = DateUtil.parse(dateStr2);

        //Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(date1, date2, BetweenFormatter.Level.MINUTE);
        //输出：31天1小时1分
        Console.log(formatBetween);
    }
}
