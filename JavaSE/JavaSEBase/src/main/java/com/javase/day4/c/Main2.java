package com.javase.day4.c;

/**
 * StringBuilder类
 * @author lixuan
 * @Date 2024/6/12 16:42
 */
public class Main2 {
    public static void main(String[] args) {
        /**
         * 我们在之前的学习中已经了解，字符串支持使用 + 和 += 进行拼接操作
         * 但是拼接字符串实际上底层需要进行很多操作，如果程序中大量进行字符串的拼接似乎不太好
         * 编译器是很聪明的，String的拼接会在编译时进行各种优化
         */

        //我们在写代码时使用的是拼接的形式
        //编译前
        String str = "杰哥" + "你干嘛";
        System.out.println(str);

        //编译后
        /*String str = "杰哥你干嘛";
        System.out.println(str);*/

        System.out.println("-----------------------");

        //对于变量来说，也有优化，比如：
        String str1 = "你看";
        String str2 = "这";
        String str3 = "汉堡";
        String str4 = "做滴";
        String str5 = "行不行";
        //5个变量连续加
        String result = str1 + str2 + str3 + str4 + str5;
        System.out.println(result);

        //如果直接使用加 + 的话，每次运算都会生成一个新的对象，这里进行4次加法运算，那么中间就需要产生4个字符串对象出来，是不是有点太浪费来了？
        //这种情况实际上会被优化成下面的写法
        StringBuilder builder = new StringBuilder();
        builder.append(str1).append(str2).append(str3).append(str4).append(str5);
        System.out.println(builder.toString());

        System.out.println("-----------------------");

        /**
         * 这里我们创建了一个StringBuilder的类型，这个类型是干嘛的呢？实际上他就是专门用于构造字符串的
         * 我们可以使用它来对字符串进行拼接、裁剪等操作，它就像一个字符串编辑器，弥补了字符串不能修改的不足
         */
        //一开始创建时，内部什么都没有
        StringBuilder builder1 = new StringBuilder();
        //我们可以使用append方法来讲字符串拼接到后面
        builder1.append("AAA");
        builder1.append("BBB");
        //当我们字符串编辑完成之后，就可以使用toString转换为字符串了
        System.out.println(builder1.toString());

        System.out.println("-----------------------");

        //它还支持裁剪等操作
        //在构造时也可以指定初始字符串
        StringBuilder builder2 = new StringBuilder("AAABBB");
        //删除2到4这个范围内的字符
        builder2.delete(2, 4);
        System.out.println(builder2.toString());


    }
}
