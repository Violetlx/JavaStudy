package com.javase.day4.d;

/**
 * 静态内部类使用
 * @author lixuan
 * @Date 2024/6/13 10:43
 */
public class Main4 {
    public static void main(String[] args) {
        //静态内部类的类名同样是之前的格式，但是可以直接new了
        Main3.Inner inner = new Main3.Inner();
        inner.show();

        //静态内部类由于是静态的，所以相对外部来说，整个内部类中都处于静态上下文（注意只是相当于外部来说）是无法访问到外部类的非静态内容的
    }
}
