package com.lambda.day2.a;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * 03-函数接口-自定义
 * @author lixuan
 * @Date 2024/7/18 14:19
 */
public class Main1 {

    @Data
    static class Student {
        private String name;
        private String sex;
        private int age;
    }

    public static void main(String[] args) {
//        Type1 obj1 = a -> (a & 1) == 0;
//        Type1 obj2 = a -> BigInteger.valueOf(a).isProbablePrime(100);
//        Type2 obj3 = (a, b, c) -> a + b + c;
//        Type3 obj4 = (a, b) -> a - b;
//        Type3 obj5 = (a, b) -> a * b;
//
//        Type6<Student> obj6 = () -> new Student();
//        Type6<List<Student>> obj7 = () -> new ArrayList<Student>();
//        Type7<String, Student> obj8 = s -> s.getName();
//        Type7<Integer, Student> obj9 = s -> s.getAge();

        IntPredicate obj1 = a -> (a & 1) == 0;
        IntPredicate obj2 = a -> BigInteger.valueOf(a).isProbablePrime(100);
        Type2 obj3 = (a, b, c) -> a + b + c;
        IntBinaryOperator obj4 = (a, b) -> a - b;
        IntBinaryOperator obj5 = (a, b) -> a * b;
        Supplier<Student> obj6 = () -> new Student();
        Supplier<List<Student>> obj7 = () -> new ArrayList<Student>();
        Function<Student, String> obj8 = s -> s.getName();
        Function<Student, Integer> obj9 = s -> s.getAge();

    }

    //编译时检查是否满足接口中有且仅有一个抽象方法

    @FunctionalInterface
    interface Type1 {
        /**
         * 抽象方法
         * @param a int
         * @return boolean
         */
        boolean op(int a);
    }

    @FunctionalInterface
    interface Type2 {
        /**
         * 抽象方法
         * @param a int
         * @param b int
         * @param c int
         * @return int
         */
        int op(int a, int b, int c);
    }

    @FunctionalInterface
    interface Type3 {
        /**
         * 抽象方法
         * @param a int
         * @param b int
         * @return int
         */
        int op(int a, int b);
    }

    @FunctionalInterface
    interface Type4 {
        /**
         * 抽象方法
         * @return Student
         */
        Student op();
    }

    @FunctionalInterface
    interface Type5<T, R> {
        /**
         * 抽象方法
         * @return Student
         */
        List<Student> op();
    }

    //用泛型简化接口

    @FunctionalInterface
    interface Type6<T> {
        /**
         * 抽象方法
         * @return T
         */
        T op();
    }

    @FunctionalInterface
    interface Type7<O, I> {
        /**
         * 抽象方法
         * @param input I
         * @return O
         */
        O op(I input);
    }
}
