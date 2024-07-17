package com.javase.day2.a;

/**
 * 变量与常量
 * @author lixuan
 */
public class Main2 {
    public static void main(String[] args) {
        //[数据类型] [变量名称];
        //声明a
        int a;

        //使用时再赋值也可以
        a=20;

        //声明并赋初值
        //直接在定义变量后面添加 = 10，表示这个变量的初始值为10，这里的10就是一个常量数字
        int b = 10;

        System.out.println("a+b="+a+b);

        //变量的值也可以在中途进行修改
        a=30;
        System.out.println("a="+a);

        //直接让变量c等于a,那么a的值会给到c
        int c = a;
        System.out.println("c="+c);


        //常量
        //常量的值只能被赋值一次
        final int d = 20;
        //d=10;  报错
        System.out.println("d="+d);
    }
}
