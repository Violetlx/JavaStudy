package com.javase.day5.a;

import java.util.Optional;

/**
 * 判空包装接口
 * @author lixuan
 * @Date 2024-06-25 16:47
 */
public class Main8 {
    public static void main(String[] args) {
        /*判空包装类 Optional*/
        String str = "111";

        if (str.isEmpty()) {
            System.out.println("空");
        }

        System.out.println("------------------");
        System.out.println("null ===> ");
        test(null);

        System.out.println("------------------");
        System.out.println(" '' ==>");
        test("");

        System.out.println("------------------");

        String s = Optional.ofNullable(str).get();
        System.out.println(s);

        Integer i = Optional
                .ofNullable(str)
                .map(String::length)
                .orElse(-1);
        System.out.println(i);
    }

    private static void test(String str){
        Optional
                .ofNullable(str)   //将传入的对象包装进Optional中
                .ifPresent(s -> System.out.println("字符串长度为："+s.length()));
        //如果不为空，则执行这里的Consumer实现
    }
}
