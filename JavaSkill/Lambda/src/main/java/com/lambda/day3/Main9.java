package com.lambda.day3;

import java.util.Comparator;
import java.util.List;

/**
 * Stream-去重
 * @author lixuan
 * @Date 2024/7/24 16:32
 */
public class Main9 {
    public static void main(String[] args) {
        //去重
        List<Integer> list = List.of(7,3,2,1,5,4,8,9,6,10,2,2,3,4,2,2,1,5,5,2,8);
        List<Integer> collect = list.stream()
                .distinct()
                .toList();
        System.out.println(collect);

        System.out.println("---------------------------");

        //排序
        List<Integer> list1 = list.stream()
                .sorted()
                .toList();
        System.out.println(list1);

        //升序
        List<Integer> list2 = list.stream()
                .sorted((o1, o2) -> o1 - o2)
                .toList();
        System.out.println(list2);

        //降序
        List<Integer> list3 = list.stream()
                .sorted((o1, o2) -> o2 - o1)
                .toList();
        System.out.println(list3);

        System.out.println("---------------------------");

        //去重+排序
        List<Integer> collect1 = list.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println(collect1);

        System.out.println("---------------------------");

        //对象的

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

        //根据武力值排序
        List<String> list4 = heroes.stream()
                .sorted((o1, o2) -> o1.i - o2.i)
                .map(hero -> hero.name)
                .toList();
        System.out.println(list4);

        System.out.println("---------------------------");

        //去重
        List<String> list5 = heroes.stream()
                .distinct()
                .map(hero -> hero.name)
                .toList();
        System.out.println(list5);

        System.out.println("---------------------------");

        //去重后根据武力值降序排列
        List<String> list6 = heroes.stream()
                .distinct()
//                .sorted((o1, o2) -> o2.i - o1.i)
//                .sorted((o1, o2) -> Integer.compare(o2.i, o1.i))
                .sorted(Comparator.comparingInt(Hero::i).reversed())
                .map(hero -> hero.name)
                .toList();
        System.out.println(list6);

        System.out.println("---------------------------");

        //排序，如果武力值相同，就按名字长度来排序
        List<String> list7 = heroes.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Hero::i).thenComparingInt(hero -> hero.name.length()))
                .map(hero -> hero.name)
                .toList();
        System.out.println(list7);

        System.out.println("---------------------------");

        //按武力值降序，如果武力值相同，就按名字长度升序
        List<String> list8 = heroes.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Hero::i).reversed().thenComparingInt(hero -> hero.name.length()))
                .map(hero -> hero.name)
                .toList();
        System.out.println(list8);
    }

    private record Hero(String name, int i) {
    }
}
