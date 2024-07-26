package com.lambda.day3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream-收集
 * @author lixuan
 * @Date 2024/7/25 9:15
 */
public class Main11 {
    /*
        收集，将元素收集到容器里
            .collect(Collectors.toList())

            ()->c               创建容器c
            (c,x)->void         将元素x加入容器C

            三个参数
            第一个参数告诉如何创建容器
            第二个参数告诉如何将元素添加容器
            第三个参数告诉如何合并容器
     */

    public static void main(String[] args) {

        List<Hero> heroes = List.of(
                new Hero("独孤求败", 100),
                new Hero("令狐冲", 90),
                new Hero("令狐冲", 90),
                new Hero("令狐冲", 90),
                new Hero("风清扬", 98),
                new Hero("风清扬", 98),
                new Hero("东方不败", 98),
                new Hero("方证", 92),
                new Hero("任我行", 92),
                new Hero("任我行", 92),
                new Hero("冲虚", 90),
                new Hero("向问天", 88),
                new Hero("不戒", 88)
        );

        //1、收集这些武侠的名称为List
        List<String> nameList = heroes.stream()
                .map(Hero::name)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nameList);

        //2、收集这些武侠的名称为Set
        Set<String> nameSet = heroes.parallelStream()
                .map(Hero::name)
                .collect(Collectors.toSet());
        System.out.println(nameSet);
        //想要保证插入顺序，需要使用LinkedHashSet
        Set<String> nameLinkedSet = heroes.parallelStream()
                .map(Hero::name)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(nameLinkedSet);

        //3、将名称和武力值对应
        Map<String, Integer> collect = heroes.parallelStream()
                .distinct()
                .collect(Collectors.toMap(Hero::name, Hero::i));
        System.out.println(collect);

        //4、字符串容器
        String nameString = heroes.parallelStream()
                .map(Hero::name)
                .collect(Collectors.joining(","));
        System.out.println(nameString);

        //StringBuilder
        StringBuilder stringBuilder = heroes.stream()
                .map(Hero::name)
                .distinct()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = heroes.stream()
                .map(Hero::name)
                .distinct()
                .collect(StringBuilder::new,  (a, b) -> {
                    if (!a.isEmpty()) {
                        a.append(",");
                    }
                    a.append(b);
                },StringBuilder::append);
        System.out.println(stringBuilder1);

        //5、StringJoiner  加上分隔符
        StringJoiner stringJoiner = heroes.stream()
                .map(Hero::name)
                .distinct()
                .collect(() -> new StringJoiner(","), StringJoiner::add, StringJoiner::merge);
        System.out.println(stringJoiner);

    }

    record Hero(String name,int i){

    }
}
