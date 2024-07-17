package com.javase.day2.c;

/**
 * 赋值运算符
 * @author lixuan
 */
public class Main2 {
    public static void main(String[] args) {
        //使用等号进行赋值运算
        int a = 666;
        System.out.println(a);
        // 赋值运算符的左边必须是一个可以赋值的目标，比如变量，右边可以是任意满足要求的值，包括变量。

        //使用连等可以将一连串变量都赋值为最右边的值。
        int b = a = 777;
        System.out.println(b+"-"+a);
    }
}
