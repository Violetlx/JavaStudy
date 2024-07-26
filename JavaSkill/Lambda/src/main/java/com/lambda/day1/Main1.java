package com.lambda.day1;

/**
 * 01-合格的函数例一
 * @author lixuan
 * @Date 2024/7/18 9:26
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(square(10));
        System.out.println(square(10));
        System.out.println(square(10));
        System.out.println(square(10));
        System.out.println(square(10));

        //square是一个合格的函数

    }

    static int square(int x) {
        return x * x;
    }
}
