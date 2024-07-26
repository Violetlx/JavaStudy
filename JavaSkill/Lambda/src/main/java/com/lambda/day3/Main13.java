package com.lambda.day3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream-下游收集器
 * @author lixuan
 * @Date 2024/7/25 10:41
 */
public class Main13 {

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

        /*
           1、mapping(x->y,dc)  需求：根据武力值分组，分组后组内只保留他们的名字

           new Hero("令狐冲“,90)->90
           dc 下游收集器 down collector
         */

        Map<Integer, List<String>> collect = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(Hero::i, Collectors.mapping(Hero::name, Collectors.toList())));
        System.out.println(collect);

        /*
           2、filtering(x->boolean,dc)  需求根据名字长度进行分组，过滤掉武力值小于90的
         */
        Map<Integer, List<Hero>> collect1 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy((h->h.name().length()), Collectors.filtering(hero -> hero.i > 90, Collectors.toList())));
        System.out.println(collect1);

        /*
           3、flatMapping(x->substring,dc)  需求：根据名字长度分组，分组后组内保留认名，并且人名切分成单个字符
         */
        Map<Integer, List<Character>> collect2 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy((h -> h.name().length()),
                        Collectors.flatMapping(hero -> hero.name().chars().mapToObj(c -> (char) c), Collectors.toList())));
        System.out.println(collect2);

        /*
           4、counting()  需求：根据武力值分组，分组后组内统计组内英雄数量
         */
        Map<Integer, Long> collect3 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(Hero::i, Collectors.counting()));
        System.out.println(collect3);

        /*
           5、summingInt(x->x)  需求：根据名字长度分组，分组后组内统计武力值总和
         */
        Map<Integer, Integer> collect4 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h->h.name.length(), Collectors.summingInt(Hero::i)));
        System.out.println(collect4);

        /*
           6、minBy((a,b)->int)  需求：根据名字长度分组，分组后组内取最小的武力值
         */
        Map<Integer, Optional<Hero>> collect5 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h -> h.name.length(), Collectors.minBy(Comparator.comparingInt(Hero::i))));
        System.out.println(collect5);

        /*
           7、maxBy((a,b)->int)  需求：根据名字长度分组，分组后组内取最大的武力值
         */
        Map<Integer, Optional<Hero>> collect6 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h -> h.name.length(), Collectors.maxBy(Comparator.comparingInt(Hero::i))));
        System.out.println(collect6);

        /*
           8、averagingInt(x->x)  需求：根据名字长度分组，分组后组内取平均武力值
         */
        Map<Integer, Double> collect7 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h -> h.name.length(), Collectors.averagingInt(Hero::i)));
        System.out.println(collect7);

        /*
           9、averagingDouble(x->x)  需求：根据名字长度分组，分组后组内统计武力值平均值
         */
        Map<Integer, Double> collect8 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h -> h.name.length(), Collectors.averagingDouble(Hero::i)));
        System.out.println(collect8);

        /*
           10、reducing(id,x->x,f)  需求：根据名字长度分组，分组后组内取武力值最大值
         */
        Map<Integer, Integer> collect9 = heroes.stream()
                .distinct()
                .collect(Collectors.groupingBy(h -> h.name.length(), Collectors.reducing(0, Hero::i, Math::max)));
        System.out.println(collect9);



    }

    record Hero(String name,int i){

    }
}
