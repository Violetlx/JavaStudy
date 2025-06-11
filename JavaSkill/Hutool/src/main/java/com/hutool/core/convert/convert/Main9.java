package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

/**
 * 数字转换
 * @author lixuan
 * @Date 2024/12/18 15:52
 */
public class Main9 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();

    }

    /**
     * 1.数字转为英文表达
     */
    public static void test1() {
        // ONE HUNDRED AND CENTS TWENTY THREE ONLY
        String format = Convert.numberToWord(100.23);
        System.out.println("test1--format==>"+format);
    }

    /**
     * 2.数字简化
     */
    public static void test2() {
        // 1.2k
        String format1 = Convert.numberToSimple(1200);
        System.out.println("test2--format1==>"+format1);
    }

    /**
     * 3.数字转为中文表达
     * 数字转中文方法中，只保留两位小数：
     */
    public static void test3() {
        // 一万零八百八十九点七二
        String f1 = Convert.numberToChinese(10889.72356, false);
        System.out.println("test3--f1==>"+f1);

        // 使用金额大写
        // 壹万贰仟陆佰伍拾叁
        String f2 = Convert.numberToChinese(12653.11, true);
        System.out.println("test3--f2==>"+f2);
    }

    /**
     * 4.数字中文表示转为数字
     */
    public static void test4() {
        // 1012
        int f1 = Convert.chineseToNumber("一千零一十二");
        System.out.println("test4--f1==>"+f1);
    }
}
