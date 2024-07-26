package com.lambda.day3;

import java.util.stream.Stream;

/**
 * Stream-流的特性
 * @author lixuan
 * @Date 2024/7/25 11:47
 */
public class Main15 {

    public static void main(String[] args) {
        /*
           掌握 Stream 流的特性
           1. 一次使用：流只能使用一次（终结方法只能调用一次）
           2. 两类操作：
             1. 中间操作，lazy 懒惰的
             2. 终结操作，eager 迫切的
         */

        //1、一次使用

        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        s1.forEach(System.out::println);
        //Stream has already been linked or consumed  这个错误是由于尝试在已经消耗或关闭的流上执行操作引起的。
        //s1.forEach(System.out::println);

        System.out.println("----------------------------");

        Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        s2.map(i -> i * 2)                                //水管
                .filter(i -> i > 5)                       //水管
                .forEach(System.out::println);            //水管  总阀门

        //中间操作可以出现多次
        //而终结操作只能出现一次
    }
}
