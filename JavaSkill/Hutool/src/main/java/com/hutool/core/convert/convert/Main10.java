package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

/**
 * 原始类和包装类转换
 * @author lixuan
 * @Date 2024/12/18 16:05
 */
public class Main10 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 原始类和包装类转换
     */
    public static void test1() {
        //去包装
        Class<?> wrapClass = Integer.class;

        //结果为：int.class
        Class<?> unWraped = Convert.unWrap(wrapClass);
        System.out.println("test1--unWraped==>"+unWraped);

        //包装
        Class<?> primitiveClass = long.class;

        //结果为：Long.class
        Class<?> wraped = Convert.wrap(primitiveClass);
        System.out.println("test1--wraped==>"+wraped);

    }
}
