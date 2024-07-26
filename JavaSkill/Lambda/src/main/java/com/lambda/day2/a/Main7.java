package com.lambda.day2.a;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 06-方法引用-5
 * @author lixuan
 * @Date 2024/7/18 15:55
 */
public class Main7 {
    /**
     * 对于无需返回值的函数接口，例如Consumer、Runnable，它们可以配合有返回值的函数对象使用
     * @param args void
     */
    public static void main(String[] args) {
        Consumer<Object> x = Main7::print1;
        Function<Object, Integer> y = Main7::print2;
        Consumer<Object> z = Main7::print2;
    }

    static void print1(Object obj) {
        System.out.println(obj);
    }

    static int print2(Object obj) {
        System.out.println(obj);
        return 1;
    }
}
