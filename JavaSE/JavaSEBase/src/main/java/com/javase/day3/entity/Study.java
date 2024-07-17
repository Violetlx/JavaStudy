package com.javase.day3.entity;

/**
 * 学习接口(接口)
 * @author 1045754
 */
public interface Study {  //使用interface表示这是一个接口

    /**
     * 接口中定义的静态变量只能是public static final的
     */
    public static final int a = 10;

    /**
     * 接口中定义的静态方法也只能是public的
     */
    public static void test1(){
        System.out.println("我是静态方法");
    }

    /**
     * 接口中只能定义访问权限为public的抽象方法，其中public和abstract关键字可以省略
     */
    void study();

    /**
     * 接口默认实现
     */
    default void test() {   //使用default关键字为接口中的方法添加默认实现
        System.out.println("我是默认实现");
    }
}
