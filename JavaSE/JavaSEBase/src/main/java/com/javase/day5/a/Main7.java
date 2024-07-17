package com.javase.day5.a;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * @author lixuan
 * @Date 2024-06-25 12:16
 */
public class Main7 {
    public static void main(String[] args) {
        /*Supplier 供给型接口*/
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());


        /*Consumer 消费型接口*/
        Consumer<String> consumer = System.out::println;

        consumer.accept("----------------------------------");

        consumer.andThen(s -> System.out.println(s.length()))
                .accept("hello");

        System.out.println("----------------------------------");

        /*Function 函数型接口*/
        Function<String,Integer> function = String::length;
        System.out.println(function.apply("hello"));

        System.out.println("----------------------------------");

        /*Predicate 断言型接口*/
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(predicate.test("hello1"));


    }
}
