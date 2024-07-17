package com.javase.day4.d;

import java.util.function.Function;

/**
 * Lambda表达式
 * @author lixuan
 * @Date 2024/6/13 14:30
 */
public class Main8 {
    public static void main(String[] args) {
        //如果一个接口中有且只有一个待实现的抽象方法，那么我们可以将匿名内部类简写为Lambda表达式

        Study study = () -> System.out.println("学习");
        study.study();

        /**
         * Lambda具体规范
         * <p>
         * 1、标准格式为：([参数类型 参数名称,]...) ‐> { 代码语句，包括返回值 }
         * 2、和匿名内部类不同，Lambda仅支持接口，不支持抽象类
         * 3、接口内部必须有且仅有一个抽象方法（可以有多个方法，但是必须保证其他方法有默认实现，必须留一个抽象方法出来）
         */

        System.out.println("------------------------");

        //有参数和返回值
        Sleep sleep = (name) -> {
            System.out.println(name + "在睡觉");
            return name+"睡到天亮";
        };
        String sleep1 = sleep.sleep("小明");
        System.out.println(sleep1);

        //注意如果方法体中只有一个返回语句，可以直接省去花括号和return关键字
        Sleep sleep2 = (name) -> {
            return name+"睡到天亮";
        };
        System.out.println("sleep2 ===> "+sleep2.sleep("小红"));

        Sleep sleep3 = (name) -> name+"睡到天亮";
        System.out.println("sleep3 ===> "+sleep3.sleep("小张飞"));

        //如果参数只有一个，那么可以省去小括号
        Sleep sleep4 = name -> name+"睡到天亮";
        System.out.println("sleep4 ===> "+sleep4.sleep("小诸葛"));


        System.out.println("------------------------");

        //如果一个方法的参数需要的是一个接口实现
        //参数直接写成lambda表达式
        test(a -> "今天学会了"+a);

        //当然，这还只是一部分，对于已经实现的方法，如果我们想直接作为接口抽象方法的实现，我们还可以使用方法引用

    }

    private static void test(Function<String, String> function) {
        String result = function.apply("李志宏");
        System.out.println(result);
    }

}
