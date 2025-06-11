package com.hutool.core.date.chinesedate;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

/**
 * 构建ChinesDate对象
 * @author lixuan
 * @Date 2024/12/19 15:42
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.构建ChinesDate对象
     */
    public static void test1(){
        //通过农历构建
        ChineseDate chineseDateN = new ChineseDate(1992,12,14);
        System.out.println("test1--chineseDateN==>"+chineseDateN);

        //通过公历构建
        ChineseDate chineseDateG = new ChineseDate(DateUtil.parseDate("1993-01-06"));
        System.out.println("test1--chineseDateG==>"+chineseDateG);
    }
}
