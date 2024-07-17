package com.javase.day5.a;

/**
 * 泛型界限
 * @author lixuan
 * @Date 2024/6/17 15:27
 */
public class Main5 {
    public static void main(String[] args) {
        Storage<Integer> storage = new Storage<>("storage","123",123);
        System.out.println("111 ===> "+storage);

        //当我们在使用变量时，泛型通配符也支持泛型的界限  上界
        Storage<? extends Integer> storage1 = new Storage<>("storage","123",123);
        System.out.println("222 ===> "+storage1);

        //通过给设定泛型上限，我们就可以更加灵活地控制泛型的具体类型范围

        //下届
        Storage<? super Integer> storage2 = new Storage<>("storage","123",123.0);
        System.out.println("333 ===> "+storage2);
    }
}
