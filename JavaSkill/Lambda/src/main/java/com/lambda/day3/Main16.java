package com.lambda.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream-并行
 * @author lixuan
 * @Date 2024/7/25 15:06
 */
public class Main16 {
    public static void main(String[] args) {

        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                //自定义收集器
                .parallel().collect(Collector.of(
                        () -> new ArrayList(), //如何创建容器
                        (list,x)->list.add(x), //如何向容器添加数据
                        (list1,list2)->{
                            list1.addAll(list2);
                            return list1;
                        }, //如何合并两个容器的数据
                        list->list //收尾
                        // 特性：并发、是否需要收尾、是否要保证收集顺序    容器不支持并发，需要收尾，要保证元素收集顺序
                ));

        System.out.println(collect);

        System.out.println("-------------------------------------");

        /*
            1、数量问题：数据量大时才建议使用并行流
            2、线程会无限增加时间：跟CPU能处理的线程相关
            3、收尾的意义:转不可变集合，StringBuilder转String
            4、是否线程安全：不会有线程安全问题
            5、特性：
                是否需要收尾(默认收尾)
                是否需要保证顺序(默认保证)
                容器是否支持并发(默认不需要支持)

                到这选择哪一种：
                A、Characteristics.IDENTITY_FINISH + Collector.Characteristics.UNORDERED + 线程安全容器
                B、默认+线程不安全容器
         */
        ArrayList<Integer> create = Stream.of(1, 2, 3, 4,5,6,7,8,9,10)
                .parallel()
                .collect(Collector.of(
                        () -> {
                            System.out.printf("%-12s %s%n", simple(), "create");
                            return new ArrayList<Integer>();
                        },                                                      //1、如何创建容器
                        (list, x) -> {
                            List<Integer> old = new ArrayList<>(list);
                            list.add(x);
                            System.out.printf("%-12s %s.add(%d)=>%s%n", simple(), old, x, list);
                        },                                                       //2、如何给容器添加元素
                        (list1, list2) -> {
                            List<Integer> old = new ArrayList<>(list1);
                            list1.addAll(list2);
                            System.out.printf("%-12s %s.add(%s)=>%s%n", simple(), old, list2, list1);
                            return list1;
                        },                                                         //3、如何合并两个容器的数量
                        list -> list,                                              //4、收尾
                        Collector.Characteristics.IDENTITY_FINISH    //5、不需要收尾
                        ,Collector.Characteristics.UNORDERED                      //6、不需要保证顺序
                        ,Collector.Characteristics.CONCURRENT                     //7、容器支持并发
                ));
        System.out.println(create);



    }

    private static String simple() {
        return Thread.currentThread().getName();
    }
}
