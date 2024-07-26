package com.lambda.day3;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream-合并与截取
 * @author lixuan
 * @Date 2024/7/19 15:54
 */
public class Main5 {

    public static void main(String[] args) {
        //1、合并
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5);

        Stream<Integer> concat = Stream.concat(s1, s2);
        concat.forEach(System.out::println);
        /*
            1  2  3  4  5
         */

        System.out.println("==============================");

        /*
            2、截取 - 直接给出截取的位置
            stream.skip(n)：跳过前n个元素，返回一个扔掉了前n个元素的流，如果流中元素不足n个，则返回一个空流。与limit(n)互补
            stream.limit(n)：截取前n个元素，返回一个扔掉了前n个元素的流，与skip(n)互补
         */
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect1 = stream1.skip(2).toList();
        System.out.println("collect1===>"+collect1);
        List<Integer> collect2 = stream2.limit(4).toList();
        System.out.println("collect2===>"+collect2);
        List<Integer> collect3 = stream3.skip(2).limit(4).toList();
        System.out.println("collect3===>"+collect3);

        System.out.println("==============================");

        /*
            3、截取-根据条件确定截取位置
            stream.takeWhile(predicate)：返回一个扔掉前缀（包括）不满足predicate的元素，返回一个满足predicate的元素之前的元素组成的流。
            stream.dropWhile(predicate)：返回一个扔掉前缀（包括）满足predicate的元素，返回一个第一个不满足predicate的元素之后的元素组成的流。
         */
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect4 = stream4.takeWhile(i -> i < 5).toList();
        System.out.println("collect4===>"+collect4);
        List<Integer> collect5 = stream5.dropWhile(i -> i < 5).toList();
        System.out.println("collect5===>"+collect5);

    }
}
