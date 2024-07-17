package com.javase.day2.c;

/**
 * 逻辑运算符
 * @author lixuan
 * @Date 2024/4/30 10:00
 */
public class Main8 {
    public static void main(String[] args) {
        //与非门
        //同时判断一个数a是否小于等于100大于等于60
        int a = 80;
        int b = 100;
        int c = 60;
        //我们可以使用与运算符连接两个判断表达式
        boolean d = 100 >= a && a >= 60;
        //为真
        if (d) {
            System.out.println("a的值在60到100之间");
        } else {//否则为假
            System.out.println("a的值不在60到100之间");
        }

        /*
         *  &&  与运算，要求两边同时为true才能返回true
         *  ||  或运算，要求两边至少要有一个为true才能返回true
         *  !   非运算，一般放在表达式最前面，表达式用括号扩起来，表示对表达式的结果进行反转
        */

        System.out.println("---------------------------");

        //加加在后，是先赋值再自增，所以第一个表达式判断为false，根据&&的特性，直接短路了
        int a1 = 10;
        boolean b1 = a1++ > 10 && ++a1 == 12;
        System.out.println("a1 = "+a1 + ", b1 = "+b1);

        System.out.println("---------------------------");

        //三元运算符
        int a2 = 10;
        int b2 = a2 > 10 ? 20 : 30;
        System.out.println("b2 = "+b2);
    }
}
