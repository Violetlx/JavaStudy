package com.hutool.core.date.chinesedate;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

/**
 * 获取天干地支
 * @author lixuan
 * @Date 2024/12/19 15:51
 */
public class Main3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.获取天干地支
     */
    public static void test1() {
        //通过公历构建
        ChineseDate chineseDate = new ChineseDate(DateUtil.parseDate("2020-08-28"));

        // 庚子年甲申月癸卯日
        String cyclicalYMD = chineseDate.getCyclicalYMD();
        System.out.println("test1--cyclicalYMD==>"+cyclicalYMD);
    }
}
