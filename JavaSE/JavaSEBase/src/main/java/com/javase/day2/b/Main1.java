package com.javase.day2.b;

/**
 * 整数类型
 * @author lixuan
 */
public class Main1 {
    public static void main(String[] args) {
        //byte字节型 （8个bit，也就是1个字节）范围：-128~+127
        byte b = 127;
        System.out.println(b);

        //short短整型（16个bit，也就是2个字节）范围：-32768~+32767
        short s = 32767;
        System.out.println(s);

        //int整型（32个bit，也就是4个字节）范围：-2147483648~+2147483647
        int i = 2147483647;
        System.out.println(i);

        //long长整型（64个bit，也就是8个字节）范围：-9223372036854775808~+9223372036854775807
        long l = 9223372036854775807L;
        System.out.println(l);

        //小的整数类型传递给大的整数类型时发生了隐式类型转换
        int a = 10;
        long c = a;
        System.out.println(c);

        //大的整数类型传递给小的整数类型时发生了强制类型转换
        int d = (int)c;
    }
}
