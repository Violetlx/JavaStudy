package com.javase.day4.e;

/**
 * 断言表达式
 * @author lixuan
 * @Date 2024/6/14 15:28
 */
public class Main5 {
    public static void main(String[] args) {
        //断言表达式需要使用到 assert 关键字

        //下面表示如果assert后面的表达式判断结果为false，将抛出AssertionError错误。为true则不会
        assert true;

        int a = 10;
        assert a > 10 : "我是自定义的错误信息";
    }
}
