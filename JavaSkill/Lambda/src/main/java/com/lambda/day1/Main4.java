package com.lambda.day1;

/**
 * 02-有形的函数一
 * @author lixuan
 * @Date 2024/7/18 9:49
 */
public class Main4 {
    //函数有形，只需要化为对象即可

    //普通函数
    static int add(int a,int b) {
        return a+b;
    }


    interface Lambda {
        /**
         * 函数接口
         * @param a
         * @param b
         * @return
         */
        int calculate(int a,int b);
    }

    //函数化为对象
    static Lambda add = (a,b) -> a+b;

    /**
     * 前者是纯粹的一条两数相加规则，要使用它，需要通过Main4.add找到他，然后执行
     * 而后者(add 对象)就像长了腿，它的位置是可以变化的，想去哪里就去哪里，哪里要用到这条加法规则，把他传过去
     * 接口的目的是为了将来用它执行函数对象，此接口中只能有一个方法定义
     */

    public static void main(String[] args) {

        System.out.println(add(1,2));

        System.out.println(add.calculate(1,2));
    }
}
