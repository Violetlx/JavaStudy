package com.javase.day2.e;

/**
 * 寻找水仙花数
 * @author lixuan
 * @Date 2024/5/28 15:19
 */
public class Main1 {
    public static void main(String[] args) {

        /**
         * 水仙花数
         * 水仙花数是指一个3位数，它的每个位上的数字的3次幂之和等于它本身。例如：1^3+5^3+3^3=153
         * 现在请你设计一个Java程序,找出1000以内的所有水仙花数
         */
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            if (getNum(ge) + getNum(shi) + getNum(bai) == i) {
                System.out.println(i);
            }
        }

    }

    static int getNum(int num) {
        return num*num*num;
    }
}
