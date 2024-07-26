package com.lambda.day2.b;

/**
 * 12-闭包-Closure-1
 * @author lixuan
 * @Date 2024/7/18 16:38
 */
public class Main1 {

    @FunctionalInterface
    interface Lambda {
        /**
         * 抽象方法
         * @param y int
         * @return int
         */
        int op(int y);
    }

    static void highOrder(Lambda lambda) {
        System.out.println(lambda.op(1));
    }

    public static void main(String[] args) {
        /*
         * 函数对象 (int y) -> x + y 与他外部的变量x形成了闭包
         *
         *  effective final(没加final,但是行为上没有修改)
         *
         * Lambda表达式可以配合final和effective final的值形成闭包
         */
        int x = 10;
        highOrder(y -> x + y);

        Student student = new Student(20);
        Lambda lambda=y -> y+student.d;
        highOrder(lambda);

        student.d=40;
        highOrder(lambda);
    }

    static class Student {
        int d;

        public Student(int d) {
            this.d=d;
        }
    }

    static int a = 1;
    int b = 2;

    public void test(int c) {
        highOrder(y -> a+y);
        highOrder(y -> b+y);
        highOrder(y -> c+y);
    }
}
