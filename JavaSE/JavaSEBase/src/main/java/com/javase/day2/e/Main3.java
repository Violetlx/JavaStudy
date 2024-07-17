package com.javase.day2.e;

/**
 * 斐波那契数列
 * @author lixuan
 * @Date 2024/5/28 15:48
 */
public class Main3 {
    public static void main(String[] args) {
        //斐波那契数列是指从第三个数开始，每个数字的值都是前两个数字的和
        int num1 = 1;
        int num2 = 1;
        for (int i = 1; i <= 10; i++) {
            int num3 = num1 + num2;
            System.out.println(num3);
            num1 = num2;
            num2 = num3;
        }

        System.out.println("-----------------------");

        //现在请你设计一个Java程序，可以获取到斐波那契数列上任意一位的数字，比如获取第五个数，那么就是5
        int target = 3,result;

        int a=1,b=1,tmp;

        for (int i = 1; i < target; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }

        result = a;

        System.out.println(result);
    }
}
