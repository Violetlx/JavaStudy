package com.lambda.day3;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Stream-收集器
 * @author lixuan
 * @Date 2024/7/25 10:23
 */
public class Main12 {

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

        //Collectors

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

        //4、将武将按照武力值分组
        Map<Integer, List<Hero>> collect1 = heroes.parallelStream()
                .collect(Collectors.groupingBy(Hero::i));
        System.out.println(collect1);

        //5、将武将按照武力值分组，并统计每个武将的数量
        Map<String, Long> collect2 = heroes.parallelStream()
                .collect(Collectors.groupingBy(Hero::name, Collectors.counting()));
        System.out.println(collect2);

        //6、将武将按照武力值分组，并统计每个武将的数量
        Map<Integer, Long> collect3 = heroes.parallelStream()
                .collect(Collectors.groupingBy(Hero::i, Collectors.counting()));
        System.out.println(collect3);

        //7、将武将按照武力值分组,返回List
        Map<Integer, List<Hero>> collect4 = heroes.parallelStream()
                .collect(Collectors.groupingBy(Hero::i, Collectors.toList()));
        System.out.println(collect4);

    }

    record Hero(String name,int i){

    }
}
