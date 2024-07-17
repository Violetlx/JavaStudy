package com.javase.day4.f;

import java.util.Random;

/**
 * 数学工具类
 * @author lixuan
 * @Date 2024/6/14 15:36
 */
public class Main1 {
    public static void main(String[] args) {
        //Math也是java.lang包下的类，所以说默认就可以直接使用
        //我们可以使用pow方法直接计算a的b次方
        System.out.println("5^3 ===> "+Math.pow(5, 3));

        //abs方法可以求绝对值
        Math.abs(-1);
        System.out.println("-1的绝对值 ===> "+Math.abs(-1));
        //round方法可以四舍五入
        Math.round(1.5);
        System.out.println("1.5四舍五入 ===> "+Math.round(1.5));
        //ceil方法可以向上取整
        Math.ceil(1.1);
        System.out.println("1.1向上取整 ===> "+Math.ceil(1.1));
        //floor方法可以向下取整
        Math.floor(1.9);
        System.out.println("1.9向下取整 ===> "+Math.floor(1.9));
        //random方法可以产生一个随机数
        Math.random();
        System.out.println("随机数 ===> "+Math.random());
        //快速取最大值
        Math.max(19, 20);
        System.out.println("19，，20取最大值 ===> "+Math.max(19, 20));
        //快速取最小值
        Math.min(2, 4);
        System.out.println("2,4取最小值 ===> "+Math.min(2, 4));
        //求一个数的算术平方根
        Math.sqrt(9);
        System.out.println("9的算术平方根 ===> "+Math.sqrt(9));

        //三角函数

        //求π/2的正弦值，这里我们可以使用预置的PI进行计算
        Math.sin(Math.PI / 2);
        System.out.println("π/2的正弦值 ===> "+Math.sin(Math.PI / 2));
        //求π的余弦值
        Math.cos(Math.PI);
        System.out.println("π的余弦值 ===> "+Math.cos(Math.PI));
        //求π/4的正切值
        Math.tan(Math.PI / 4);
        System.out.println("π/4的正切值 ===> "+Math.tan(Math.PI / 4));

        //三角函数的反函数也是有的，这里是求arcsin1的值
        Math.asin(1);
        System.out.println("arcsin1 ===> "+Math.asin(1));
        Math.acos(1);
        System.out.println("arccos1 ===> "+Math.acos(1));
        Math.atan(0);
        System.out.println("arctan0 ===> "+Math.atan(0));

        //对数

        //e为底的对数函数，其实就是ln，我们可以直接使用Math中定义好的e
        Math.log(Math.E);
        System.out.println("e的ln ===> "+Math.log(Math.E));
        //10为底的对数函数
        Math.log10(100);
        System.out.println("10的ln ===> "+Math.log10(100));
        //利用换底公式，我们可以弄出来任何我们想求的对数函数
        //这里是求以2为底4的对数，log(2)4 = ln4 / ln2
        double a = Math.log(4) / Math.log(2);
        System.out.println("以2为底4的对数 ===> "+a);
        System.out.println(a);

        System.out.println("------------------------");

        //创建Random对象
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            //nextInt方法可以指定创建0 - x之内的随机数
            System.out.print(random.nextInt(100)+" ");
        }
    }
}
