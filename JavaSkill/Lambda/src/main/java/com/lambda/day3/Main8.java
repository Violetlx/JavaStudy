package com.lambda.day3;

import java.util.List;

/**
 * Stream-判断
 * @author lixuan
 * @Date 2024/7/24 16:26
 */
public class Main8 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1、判断是否都为正数
        boolean b = list.stream().allMatch(i -> i > 0);
        System.out.println("是否都为正数:"+b);

        System.out.println("----------------------------");

        //2、判断是否有偶数存在
        boolean b1 = list.stream().anyMatch(i -> i % 2 == 0);
        System.out.println("是否有偶数存在:"+b1);

        System.out.println("----------------------------");

        //3、判断是否都不为正数
        boolean b2 = list.stream().noneMatch(i -> i > 0);
        System.out.println("是否都不为正数:"+b2);
    }
}
