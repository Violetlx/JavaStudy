package com.lambda.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Stream-化简
 * @author lixuan
 * @Date 2024/7/24 17:04
 */
public class Main10 {

    public static void main(String[] args) {
        /*
            化简：两两合并，只有一个
            适合：最大值、最小值、求和、求个数
                 .reduce((p,x)->r)   p 上次合并的结果  x 当前元素  r 本次合并结果
                 .reduce(init,(p,x)->r)
                 .reduce(init,(p,x)->r,(r1,r2)->r)
         */

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

        List<Hero> list = new ArrayList<>();

        //1、返回武力值最高的
        Optional<Hero> result = heroes.stream()
                .reduce((p, x) -> p.i > x.i ? p : x);
        System.out.println(result);

        //2、返回武力值最高的，如果没有则返回初始值
        Hero reduce = list.stream()
                .reduce(new Hero("幼狼", 0), (p, x) -> p.i > x.i ? p : x);
        System.out.println(reduce);

        //3、求高手总数
        int count = heroes.stream()
                .distinct()
                .reduce(0, (p, x) -> p + 1, Integer::sum);
        System.out.println(count);

        Integer count1 = heroes.stream()
                .distinct()
                .map(h -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count1);

        //4、求和
        long count2 = heroes.stream()
                .distinct()
                .count();
        System.out.println(count2);

        //5、求最大值
        heroes.stream()
                .distinct()
                .max(Comparator.comparingInt(Hero::i))
                .ifPresent(System.out::println);

        //6、求最小值
        heroes.stream()
                .distinct()
                .min(Comparator.comparingInt(Hero::i))
                .ifPresent(System.out::println);

        //7、求和
        int sum = heroes.stream()
                .distinct()
                .mapToInt(Hero::i)
                .sum();
        System.out.println(sum);

        //8、求武力平均值
        double avg = heroes.stream()
                .distinct()
                .mapToInt(Hero::i)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    record Hero(String name,int i){

    }
}
