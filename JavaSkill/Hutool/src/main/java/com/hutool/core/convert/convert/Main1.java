package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

import java.util.List;

/**
 * Java常见类型转换
 * @author lixuan
 * @Date 2024/12/18 14:27
 */
public class Main1 {
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
     * 1.转换为字符串
     */
    public static void test1(){
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println("test1--aStr==>"+aStr);

        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println("test1--bStr==>"+bStr);

        //结果：
        //test1--aStr==>1
        //test1--bStr==>[1, 2, 3, 4, 5]
    }

    /**
     * 2.转换为指定类型数组
     */
    public static void test2(){
        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        for (Integer integer : intArray) {
            System.out.println("test2--integer==>"+integer);
        }

        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        for (Integer integer : intArray2) {
            System.out.println("test2--integer==>"+integer);
        }

        //结果：
        //test2--integer==>1
        //test2--integer==>2
        //test2--integer==>3
        //test2--integer==>4
        //test2--integer==>1
        //test2--integer==>2
        //test2--integer==>3
        //test2--integer==>4
        //test2--integer==>5
    }

    /**
     * 3.转换为日期对象
     */
    public static void test3(){
        String dateStr = "2024-12-18";
        //结果为：2024-12-18 00:00:00
        java.util.Date date = Convert.toDate(dateStr);
        System.out.println("test3--date==>"+date);

        //结果：
        //test3--date==>Wed Dec 18 00:00:00 CST 2024
    }

    /**
     * 4.转换为集合
     */
    public static void test4(){
        Object[] a = {"a", "你", "好", "", 1};
        //List<?> list = Convert.convert(List.class, a);
        //从4.1.11开始可以这么用
        List<?> list = Convert.toList(a);
        System.out.println("test4--list==>"+list);

        //结果：
        //test4--list==>[a, 你, 好, , 1]
    }
}
