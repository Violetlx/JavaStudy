package com.javase.day2.c;

/**
 * 关系运算符
 * @author lixuan
 * @Date 2024/4/30 9:56
 */
public class Main7 {
    public static void main(String[] args) {
        //关系运算符
        int a = 10;
        int b = 20;
        //进行判断，如果a > b那么就会得到true，否则会得到false
        boolean c = a>b;
        boolean d = a<b;
        boolean e = a>=b;
        boolean f = a<=b;
        boolean g = a==b;
        boolean h = a!=b;
        System.out.println("a>b => "+c);
        System.out.println("a<b => "+d);
        System.out.println("a>=b => "+e);
        System.out.println("a<=b => "+f);
        System.out.println("a==b => "+g);
        System.out.println("a!=b => "+h);


    }
}
