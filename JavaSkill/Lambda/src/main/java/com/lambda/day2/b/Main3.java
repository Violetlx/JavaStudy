package com.lambda.day2.b;

/**
 * 13-柯里化-1
 * @author lixuan
 * @Date 2024/7/19 9:09
 */
public class Main3 {
    /*
        1、什么是柯里化？
        让接收多个参数的函数转换成一系列接收一个参数的函数
        2、如何实现柯里化？
        结合闭包实现
        让函数分布执行
     */

    @FunctionalInterface
    interface F2 {
        int op(int a, int b);
    }

    @FunctionalInterface
    interface Fa {
        Fb op(int a);
    }

    @FunctionalInterface
    interface Fb {
        int op(int b);
    }

    public static void main(String[] args) {
        // 两个参数的函数对象
        F2 f2 = (a, b) -> a + b;
        System.out.println(f2.op(10, 20));

        /* 改造

            (a) -> 返回另一个函数对象
                    (b) -> a+b
         */
        Fa fa = (a) -> (b) -> a + b;
        Fb fb = fa.op(10);
        int r = fb.op(20);
        System.out.println(r);
    }
}
