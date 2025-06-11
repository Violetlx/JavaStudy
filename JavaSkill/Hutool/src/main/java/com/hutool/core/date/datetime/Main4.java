package com.hutool.core.date.datetime;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;

/**
 * 格式化字符串
 * @author lixuan
 * @Date 2024/12/19 15:30
 */
public class Main4 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        //结果：2017-01-05 12:34:23
        String dateStr = dateTime.toString();
        System.out.println("test1--dateStr==>"+dateStr);

        //结果：2017/01/05
        String dateStr1 = dateTime.toString("yyyy/MM/dd");
        System.out.println("test1--dateStr1==>"+dateStr1);

    }
}
