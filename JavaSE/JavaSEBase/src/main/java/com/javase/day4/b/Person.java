package com.javase.day4.b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * 人(可变长参数)
 * @author lixuan
 * @Date 2024/6/12 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String name;
    int age;
    String sex;

    public void test(String... args) {
        System.out.println(args.length);
        Arrays.stream(args).forEach(System.out::println);
    }
}
