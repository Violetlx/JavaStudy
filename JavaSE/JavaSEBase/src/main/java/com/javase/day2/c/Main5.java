package com.javase.day2.c;

/**
 * 自增自减运算符
 * @author lixuan
 * @Date 2024/4/29 15:55
 */
public class Main5 {
    public static void main(String[] args) {
        int a = 10;
        //加加在后,先赋值再自增
        System.out.println(a++);
        System.out.println(a);
        System.out.println("-------------------");
        //加加在前，先自增再赋值
        System.out.println(++a);
        System.out.println(a);
        System.out.println("-------------------");
        //减减在后，先赋值再自减
        System.out.println(a--);
        System.out.println(a);
        System.out.println("-------------------");
        //减减在前，先自减再赋值
        System.out.println(--a);
        System.out.println(a);

        System.out.println("-------------------");

        int b = 8;
        b = b + 4;
        b += 4;
        System.out.println(b);
    }
}
