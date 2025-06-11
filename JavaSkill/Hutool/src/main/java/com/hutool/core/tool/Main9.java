package com.hutool.core.tool;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 泛型类型工具-TypeUtil
 * @author lixuan
 * @Date 2024/12/29 9:35
 */
public class Main9 {

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
     * 1 getClass
     */
    private static void test1(){
        // 获取type对应的原始类
        Class<?> clazz = TypeUtil.getClass(TestClass.class);
        System.out.println("test1--clazz==>"+clazz);

        //结果：
        //test1--clazz==>class com.hutool.core.tool.TestClass
    }

    /**
     * 2 getParamType
     */
    private static void test2(){
        // 获取方法参数类型
        Method method = ReflectUtil.getMethod(TestClass.class, "intTest", Integer.class);
        Type type = TypeUtil.getParamType(method, 0);
        System.out.println("test2--type==>"+type);

        //结果：
        //test2--type==>class java.lang.Integer
    }

    /**
     * 3 getReturnType
     */
    private static void test3(){
        // 获取方法返回类型
        Method method = ReflectUtil.getMethod(TestClass.class, "intTest", Integer.class);
        Type type = TypeUtil.getReturnType(method);
        System.out.println("test3--type==>"+type);

        //结果：
        //test3--type==>class java.lang.Integer
    }

    /**
     * 4 getTypeArgument
     */
    private static void test4(){
        //获取泛型类子类中泛型的填充类型

        // 获取泛型类型
        Method method = ReflectUtil.getMethod(TestClass.class, "getList");
        Type type = TypeUtil.getReturnType(method);

        Type type2 = TypeUtil.getTypeArgument(type);
        // 结果：String.class
        System.out.println("test4--type==>"+type2);

        //结果：
        //test4--type==>class java.lang.String
    }

}
