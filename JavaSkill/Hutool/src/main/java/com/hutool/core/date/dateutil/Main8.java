package com.hutool.core.date.dateutil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;

/**
 * 星座和属相
 * @author lixuan
 * @Date 2024/12/19 14:20
 */
public class Main8 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.星座和属相
     */
    public static void test1() {
        // "摩羯座"
        String zodiac = DateUtil.getZodiac(Month.JANUARY.getValue(), 19);
        System.out.println("test1--zodiac==>"+zodiac);

        // "狗"
        String chineseZodiac = DateUtil.getChineseZodiac(1994);
        System.out.println("test1--chineseZodiac==>"+chineseZodiac);
    }
}
