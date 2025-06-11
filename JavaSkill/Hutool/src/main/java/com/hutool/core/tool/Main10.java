package com.hutool.core.tool;

import cn.hutool.core.util.PageUtil;

import java.util.Arrays;

/**
 * 分页工具-PageUtil
 * @author lixuan
 * @Date 2024/12/29 17:40
 */
public class Main10 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
    }

    /**
     * 1 transToStartEnd
     */
    private static void test1() {
        //将页数和每页条数目转换为开始位置和结束位置。此方法用于包括结束位置的分页方法。

        //[0, 10]
        int[] startEnd1 = PageUtil.transToStartEnd(0, 10);
        System.out.println("test1--startEnd1==>"+ Arrays.toString(startEnd1));

        //[10, 20]
        int[] startEnd2 = PageUtil.transToStartEnd(1, 10);
        System.out.println("test1--startEnd2==>"+ Arrays.toString(startEnd2));

        //结果：
        //test1--startEnd1==>[0, 10]
        //test1--startEnd2==>[10, 20]
    }

    /**
     * 2 totalPage
     */
    private static void test2() {
        //计算总页数
        int totalPage = PageUtil.totalPage(100, 10);
        System.out.println("test2--totalPage==>"+totalPage);

        //结果：
        //test2--totalPage==>10
    }

    /**
     * 3 分页彩虹算法
     */
    private static void test3(){
        //分页彩虹算法
        int[] rainbow = PageUtil.rainbow(5, 20, 6);
        System.out.println("test3--rainbow==>"+Arrays.toString(rainbow));

        //结果：
        //test3--rainbow==>[3, 4, 5, 6, 7, 8]
    }
}
