package com.lambda.day2.c;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * 14-高阶函数-内循环
 * @author lixuan
 * @Date 2024/7/19 9:28
 */
public class Main1 {
    /*
       1、不想自己写集合遍历代码
       2、不知道哪种集合遍历效果高
       3、对集合元素进行只读操作
     */

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //需求：逆序遍历集合，只想负责元素处理，不改变集合
        highOrder(list,(value) -> System.out.println(value));
    }

    public static <T> void highOrder(List<T> list, Consumer consumer) {
        ListIterator<T> integerListIterator = list.listIterator(list.size());
        while (integerListIterator.hasPrevious()) {
            T value = integerListIterator.previous();
            consumer.accept(value);
        }
    }
}
