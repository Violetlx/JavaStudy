package com.lambda.day2.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 05-函数接口练习
 * @author lixuan
 * @Date 2024/7/18 14:51
 */
public class Main2 {
    public static void main(String[] args) {
        List<Integer> result = filter(List.of(1, 2, 3, 4, 5, 6), (Integer number) -> (number & 1) == 1);
        System.out.println(result);

        System.out.println("===============================");

        List<String> map = map(List.of(1, 2, 3, 4, 5, 6), (Integer number) -> String.valueOf(number));
        System.out.println(map);

        System.out.println("===============================");

        consume(List.of(1, 2, 3, 4, 5, 6), (Integer number) -> System.out.println(number));

        System.out.println("===============================");

        List<Integer> supply = supply(10, () -> ThreadLocalRandom.current().nextInt());
        System.out.println(supply);
    }

    /**
     * 筛选，可以使用函数式接口Predicate来进行判断(Predicate返回需要给个参数，返回boolean值)
     * @param list List<Integer>
     * @param predicate Predicate<Integer>
     * @return List<Integer>
     */
    static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            // 筛选：判断是否是偶数，但以后可能改变筛选规则
            if(predicate.test(number)) {
                result.add(number);
            }
        }
        return result;

        /*
            (Integer number) -> (number & 1) == 0
         */
    }

    /**
     * 转换，可以使用函数式接口Function来进行转换(Function 给个参数，返回值)
     * @param list List<Integer> list
     * @param func Function<Integer,String>
     * @return List<String>
     */
    static List<String> map(List<Integer> list, Function<Integer,String> func) {
        List<String> result = new ArrayList<>();
        for (Integer number : list) {
            // 转换：将数字转为字符串，但以后可能改变转换规则
            // result.add(String.valueOf(number))
            result.add(func.apply(number));
        }
        return result;

        /**
         * (Integer number) -> String.valueOf(number)
         */
    }

    /**
     * 消费，可以使用函数式接口Consumer来进行消费(Consumer 给个参数，返回值void，直接控制台打印)
     * @param list List<Integer>
     * @param consumer Consumer<Integer>
     */
    static void consume(List<Integer> list, Consumer<Integer> consumer) {
        for (Integer number : list) {
            // 消费：打印，但以后可能改变消费规则
            // System.out.println(number)
            consumer.accept(number);
        }

        /**
         * (Integer number) -> System.out.println(number)
         */
    }

    /**
     * 生成，可以使用函数式接口Supplier来进行生成(Supplier 不给参数，返回值)
     * @param count int
     * @return Supplier<Integer>
     */
    static List<Integer> supply(int count, Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 生成：随机数，但以后可能改变生成规则
            //result.add(ThreadLocalRandom.current().nextInt())
            result.add(supplier.get());
        }
        return result;

        /**
         * () -> ThreadLocalRandom.current().nextInt()
         */
    }
}
