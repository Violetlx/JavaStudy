package com.javase.day2.c;

/**
 * 位运算
 * @author lixuan
 * @Date 2024/4/29 16:00
 */
public class Main6 {
    public static void main(String[] args) {
        //进行按位与运算
        int a = 9, b = 3;
        int c = a & b;
        System.out.println(c);

        System.out.println("----------------------");

        //按位或
        int d = a | b;
        System.out.println(d);

        System.out.println("----------------------");

        //按位异或
        int e = a ^ b;
        System.out.println(e);

        System.out.println("----------------------");

        //按位取反
        byte f = ~127;
        System.out.println(f);

        //127 = 01111111  -128 = 10000000  取反后 = 10000000 - 1 = 01111111

        System.out.println("----------------------");

        //位移运算符
        int g = 1 << 2;
        System.out.println(g);

        //1 << 2 = 1 * 2^2 = 1 * 4 = 4     1=0001   4=00100(左移两位后，1跑到前面去了，尾部使用0填充，此时就是4)
        //左移几位就是乘以2的几倍

        int h = 16 >> 2;
        System.out.println(h);
        //1 >> 2 = 1 / 2^2 = 1 / 4 = 0.25   1=0001   0.25=0000.01(右移两位后，1跑到后面去了，头部使用0填充，此时就是0.25)
        //右移几位就是除以2的几倍

        //对于负数来说，左移和右移操作不会改变其符号位上的数字，符号位不受位移操作影响
        int i = -4;
        System.out.println(i << 2);
        System.out.println(i >> 2);

        /*
         * 左移操作<<： 高位直接丢弃，低位补0
         * 右移操作>>： 低位直接丢弃，符号位是什么高位补什么
         */
    }
}
