package com.javase.day2.d;

/**
 * 循环结构(二) while循环
 * @author lixuan
 * @Date 2024/5/28 14:34
 */
public class Main4 {
    public static void main(String[] args) {

        //while(循环条件) 循环体;

        //相比于for循环，while循环更多的作用是用在不明确具体的结束时机的情况下，而for循环更多用于明确知道循环的情况

        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("------------------------------");

        //和for循环一样,while也支持使用break和continue来进行循环控制以及嵌套使用

        int a=10;
        while (a<=20) {
            if (a==15) {
                break;
            }
            System.out.println(a);
            a++;
        }

        System.out.println("------------------------------");

        //当然我们也可以反转循环判断的时机，可以先执行循环内容，然后再进行循环条件判断，这里就要用到do-while语句
        int b=10;
        do {
            System.out.println(b);
            b++;
        }while (b<=20);
    }
}
