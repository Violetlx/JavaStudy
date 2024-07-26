package com.lambda.day3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Stream-构建
 * @author lixuan
 * @Date 2024/7/19 15:46
 */
public class Main4 {
    /*
        用已有数据构建出Stream对象
        1、从集合构建   集合.stream()
        2、从数组构建   Arrays.stream(数组)
        3、从对象构建   Stream.of(对象)
     */

    public static void main(String[] args) {
        System.out.println("从集合构建===>");
        System.out.println("从List集合构建===>");
        //List
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .forEach(System.out::println);

        System.out.println("从Set集合构建===>");

        //Set
        Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .forEach(System.out::println);

        System.out.println("从Map集合构建===>");

        //Map
        Map.of("a",1, "b",2, "c",3)
                .entrySet()
                .stream()
                .forEach(System.out::println);

        System.out.println("从数组构建===>");
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .forEach(System.out::println);

        System.out.println("从对象构建===>");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(System.out::println);
    }
}
