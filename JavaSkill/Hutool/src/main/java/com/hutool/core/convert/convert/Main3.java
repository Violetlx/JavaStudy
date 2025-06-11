package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

/**
 * 半角和全角转换
 * @author lixuan
 * @Date 2024/12/18 14:58
 */
public class Main3 {
    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.半角转全角
     */
    public static void test1() {
        String a = "123456789";

        //结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);
        System.out.println("test1--sbc==>"+sbc);
    }

    /**
     * 2.全角转半角
     */
    public static void test2() {
        String a = "１２３４５６７８９";

        //结果为："123456789"
        String dbc = Convert.toDBC(a);
        System.out.println("test2--dbc==>"+dbc);
    }

}
