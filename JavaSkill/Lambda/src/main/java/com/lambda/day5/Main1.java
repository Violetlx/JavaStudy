package com.lambda.day5;

import java.lang.reflect.Method;
import java.util.function.BinaryOperator;

/**
 * lambda原理-生成静态方法
 * @author lixuan
 * @Date 2024/7/26 15:37
 */
public class Main1 {
    public static void main(String[] args) {
        BinaryOperator<Integer> lambdas = Integer::sum;
        System.out.println(lambdas.apply(1, 2));

        //如何证明？用反射
        for (Method declaredMethod : Main1.class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }


        /*
            Lambda 表达式是一种语法糖，它仍然会被编译成类、对象、方法
            1、方法从哪来
            2、类和对象从哪来
         */
    }
}
