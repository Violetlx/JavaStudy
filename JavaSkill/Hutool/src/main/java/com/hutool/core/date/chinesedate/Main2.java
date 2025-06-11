package com.hutool.core.date.chinesedate;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

/**
 * 基本使用
 * @author lixuan
 * @Date 2024/12/19 15:46
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        //通过公历构建
        ChineseDate date = new ChineseDate(DateUtil.parseDate("2020-01-25"));
        // 一月
        String chineseMonth = date.getChineseMonth();
        System.out.println("test1--chineseMonth==>"+chineseMonth);
        // 正月
        String chineseMonthName = date.getChineseMonthName();
        System.out.println("test1--chineseMonthName==>"+chineseMonthName);
        // 初一
        String chineseDay = date.getChineseDay();
        System.out.println("test1--chineseDay==>"+chineseDay);
        // 庚子
        String cyclical = date.getCyclical();
        System.out.println("test1--cyclical==>"+cyclical);
        // 生肖：鼠
        String chineseZodiac = date.getChineseZodiac();
        System.out.println("test1--chineseZodiac==>"+chineseZodiac);
        // 传统节日（部分支持，逗号分隔）：春节
        String festivals = date.getFestivals();
        System.out.println("test1--festivals==>"+festivals);
        // 庚子鼠年 正月初一
        String string = date.toString();
        System.out.println("test1--string==>"+string);
    }
}
