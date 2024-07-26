package com.lambda.day3;

import java.util.stream.Stream;

/**
 * Stream-过滤
 * @author lixuan
 * @Date 2024/7/19 15:13
 */
public class Main1 {

    public static void main(String[] args) {
        Stream<Fruit> fruitStream = Stream.of(
                new Fruit("草莓", "Strawberry", "浆果", "红色"),
                new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                new Fruit("核桃", "Walnut", "坚果", "棕色"),
                new Fruit("花生", "Peanut", "坚果", "棕色"),
                new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
        );

        //filter 过滤
        fruitStream
                //.filter(fruit -> "浆果".equals(fruit.category) && "蓝色".equals(fruit.color))
                .filter(fruit -> "浆果".equals(fruit.category))
                .filter(fruit -> "蓝色".equals(fruit.color))
                .forEach(System.out::println);
    }

    record Fruit(String cname,String name,String category, String color) {
    }
}
