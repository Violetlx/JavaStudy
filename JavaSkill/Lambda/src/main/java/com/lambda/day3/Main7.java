package com.lambda.day3;

import java.util.List;

/**
 * Stream-查找
 * @author lixuan
 * @Date 2024/7/24 15:48
 */
public class Main7 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //查找第一个
        list.stream()
                .filter(i -> i % 2 == 0)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("----------------------------------");

        //查找任意一个  在串行流实际上和findFirst()一样
        Integer i1 = list.stream()
                .filter(i -> i % 2 == 0)
                .findAny()
                .orElse(-1);
        System.out.println(i1);

        System.out.println("----------------------------------");
        //查找任意一个 但是在并行流中，会随机返回一个
        list.parallelStream()
                .filter(i -> i % 2 == 0)
                .findAny()
                .ifPresent(System.out::println);
    }
}
