package com.javase.day5.a;

/**
 * 类型擦除
 * @author lixuan
 * @Date 2024/6/17 15:40
 */
public class Main6 {
    public static void main(String[] args) {
        /**
         * public abstract class A <T>{
         *     abstract T test(T t);
         * }
         *
         * public abstract class A {
         *     abstract Object test(Object t);  //默认就是Object
         * }
         *
         *
         * public abstract class A <T extends Number>{   //设定上界为Number
         *     abstract T test(T t);
         * }
         *
         * public abstract class A {
         *     abstract Number test(Number t);  //上界Number，因为现在只可能出现Number的子类
         * }
         */
    }
}
