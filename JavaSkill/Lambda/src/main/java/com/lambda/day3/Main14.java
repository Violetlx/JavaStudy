package com.lambda.day3;

import java.util.List;
import java.util.stream.*;

/**
 * Stream-基本类型流
 * @author lixuan
 * @Date 2024/7/25 11:41
 */
public class Main14 {
    public static void main(String[] args) {
        //基本流
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0);

        //普通流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Long> longStream1 = Stream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        Stream<Double> doubleStream1 = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0);

        //基本类型流效率高，占用空间小

        List<String> collect = intStream.mapToObj(Character::toString).collect(Collectors.toList());
        System.out.println(collect);
    }
}
