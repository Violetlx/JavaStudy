package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 开始和结束时间
 * @author lixuan
 * @Date 2024/12/19 12:15
 */
public class Main4 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.开始和结束时间
     */
    public static void test1(){
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        System.out.println("test1--beginOfDay==>"+beginOfDay);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println("test1--endOfDay==>"+endOfDay);

    }
}
