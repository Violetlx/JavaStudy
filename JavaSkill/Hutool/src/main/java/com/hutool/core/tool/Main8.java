package com.hutool.core.tool;


import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

/**
 * 反射工具-ReflectUtil
 * @author lixuan
 * @Date 2024/12/28 16:16
 */
public class Main8 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();
    }

    /**
     * 1 获取某个类的所有方法
     */
    private static void test1() {
        Method[] methods = ReflectUtil.getMethods(TestClass.class);
        for (Method method : methods) {
            System.out.println("test1--method==>"+method.getName());
        }

        //结果：
        //test1--method==>setA
        //test1--method==>getA
        //test1--method==>finalize
        //test1--method==>wait
        //test1--method==>wait
        //test1--method==>wait
        //test1--method==>equals
        //test1--method==>toString
        //test1--method==>hashCode
        //test1--method==>getClass
        //test1--method==>clone
        //test1--method==>notify
        //test1--method==>notifyAll
    }

    /**
     * 2 获取某个类的指定方法
     */
    private static void test2() {
        Method method = ReflectUtil.getMethod(TestClass.class, "setA", int.class);
        System.out.println("test2--method==>"+method.getName());

        //结果：
        //test2--method==>setA
    }

    /**
     * 3 构造对象
     */
    private static void test3() {
        TestClass testClass = ReflectUtil.newInstance(TestClass.class);
        testClass.setA(10);
        System.out.println("test3--testClass.getA()==>"+testClass.getA());

        //结果：
        //test3--testClass.getA()==>10
    }

    /**
     * 4 反射工具
     */
    private static void test4() {
        TestClass testClass = new TestClass();
        ReflectUtil.invoke(testClass, "setA", 10);
        int a = testClass.getA();
        System.out.println("test1--a==>"+ a);

        //结果：
        //test1--a==>10
    }

}
