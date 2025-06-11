package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

import java.util.concurrent.TimeUnit;

/**
 * 时间单位转换
 * @author lixuan
 * @Date 2024/12/18 15:41
 */
public class Main7 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 时间单位转换
     */
    public static void test1() {
        long a = 4535345;

        //结果为：75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println("test1--minutes==>"+minutes);
    }
}
