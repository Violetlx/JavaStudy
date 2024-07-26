package com.lambda.day3;

import java.util.stream.Stream;

/**
 * Stream-映射
 * @author lixuan
 * @Date 2024/7/19 15:13
 */
public class Main2 {

    public static void main(String[] args) {
        Stream<Fruit> fruitStream = Stream.of(
                new Fruit("草莓", "Strawberry", "浆果", "红色"),
                new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                new Fruit("核桃", "Walnut", "坚果", "棕色"),
                new Fruit("花生", "Peanut", "坚果", "棕色"),
                new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
        );

        //map 映射
        fruitStream
                .map(fruit -> fruit.cname + "酱 " +fruit.name)
                .forEach(System.out::println);
    }

    record Fruit(String cname,String name,String category, String color) {
    }
}
