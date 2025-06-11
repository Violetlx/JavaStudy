package com.hutool.core.tool;

import cn.hutool.core.util.ClassUtil;

import java.util.Set;

/**
 * 类工具-ClassUtil
 * @author lixuan
 * @Date 2024/12/30 14:49
 */
public class Main12 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();
        System.out.println("---------------------------");
        test5();
        System.out.println("---------------------------");
        test6();
        System.out.println("---------------------------");
        test7();
        System.out.println("---------------------------");
        test8();
        System.out.println("---------------------------");
        test9();
        System.out.println("---------------------------");
        test10();
    }

    /**
     * 1 getShortClassName
     */
    public static void test1(){
        //获取完整类名的短格式如：cn.hutool.core.util.StrUtil -> c.h.c.u.StrUtil

        String className = "com.hutool.core.tool.Main12";
        String shortClassName = ClassUtil.getShortClassName(className);
        System.out.println("test1--shortClassName==>"+shortClassName);

        String name = Main12.class.getName();
        String shortName = ClassUtil.getShortClassName(name);
        System.out.println("test1--shortName==>"+shortName);

        //结果：
        //test1--shortClassName==>c.h.c.t.Main12
        //test1--shortName==>c.h.c.t.Main12
    }

    /**
     * 2 isAllAssignableFrom
     */
    public static void test2(){
        //判断是否所有元素都是指定类型的父类或接口

        Class<?>[] classes = new Class[]{String.class, Integer.class};
        Class<?>[] classes1 = new Class[]{String.class};
        Class<?>[] classes2 = new Class[]{String.class, Integer.class};

        boolean isAllAssignableFrom = ClassUtil.isAllAssignableFrom(classes1, classes);
        System.out.println("test2--isAllAssignableFrom==>"+isAllAssignableFrom);


        boolean isAllAssignableFrom1 = ClassUtil.isAllAssignableFrom(classes2, classes);
        System.out.println("test2--isAllAssignableFrom1==>"+isAllAssignableFrom1);

        //结果：
        //test2--isAllAssignableFrom==>false
        //test2--isAllAssignableFrom1==>true
    }

    /**
     * 3 isPrimitiveWrapper
     */
    public static void test3(){
        //判断是否为原始类型或原始类型包装类

        boolean isPrimitiveWrapper = ClassUtil.isPrimitiveWrapper(String.class);
        System.out.println("test3--isPrimitiveWrapper==>"+isPrimitiveWrapper);

        boolean isPrimitiveWrapper1 = ClassUtil.isPrimitiveWrapper(Integer.class);
        System.out.println("test3--isPrimitiveWrapper1==>"+isPrimitiveWrapper1);

        //结果：
        //test3--isPrimitiveWrapper==>false
        //test3--isPrimitiveWrapper1==>true
    }

    /**
     * 4 isBasicType
     */
    public static void test4(){
        //判断是否为原始类型或原始类型包装类

        boolean basicType = ClassUtil.isBasicType(String.class);
        System.out.println("test4--basicType==>"+basicType);

        boolean basicType1 = ClassUtil.isBasicType(Integer.class);
        System.out.println("test4--basicType1==>"+basicType1);

        boolean basicType2 = ClassUtil.isBasicType(int.class);
        System.out.println("test4--basicType2==>"+basicType2);

        //结果：
        //test4--basicType==>true
        //test4--basicType1==>true
        //test4--basicType2==>true
    }

    /**
     * 5 getPackage
     */
    public static void test5(){
        //获取包名

        String aPackage = ClassUtil.getPackage(String.class);
        System.out.println("test5--aPackage==>"+aPackage);

        String bPackage = ClassUtil.getPackage(Integer.class);
        System.out.println("test5--bPackage==>"+bPackage);

        //结果：
        //test5--aPackage==>java.lang
        //test5--bPackage==>java.lang
    }

    /**
     * 6 scanPackage
     */
    public static void test6(){
        //扫描指定包下的所有类

        Set<Class<?>> classes = ClassUtil.scanPackage("cn.hutool.core.util");
        for (Class<?> aClass : classes) {
            System.out.println("test6--aClass==>"+aClass);
        }

        //结果：
        //test6--aClass==>class cn.hutool.core.util.EnumUtil
        //test6--aClass==>class cn.hutool.core.util.CreditCodeUtil
        //test6--aClass==>class cn.hutool.core.util.ModifierUtil$ModifierType
        //...
    }

    /**
     * 7 getClassPaths
     */
    public static void test7(){
        //获取类路径

        Set<String> classPaths = ClassUtil.getClassPaths("cn.hutool.core.util");
        for (String classPath : classPaths) {
            System.out.println("test7--classPath==>"+classPath);
        }
        //结果：
        //test7--classPath==>file:/E:/maven/repository/repository/cn/hutool/hutool-all/5.8.25/hutool-all-5.8.25.jar!/cn/hutool/core/util
    }

    /**
     * 8 getJavaClassPaths
     */
    public static void test8(){
        //获取Java类路径

        String[] javaClassPaths = ClassUtil.getJavaClassPaths();
        for (String javaClassPath : javaClassPaths) {
            System.out.println("test8--javaClassPath==>"+javaClassPath);
        }
        //结果：
        //test8--javaClassPath==>E:\Study\JavaSkill\Hutool\target\classes
        //test8--javaClassPath==>E:\maven\repository\repository\org\springframework\boot\spring-boot-starter\3.3.1\spring-boot-starter-3.3.1.jar
        //test8--javaClassPath==>E:\maven\repository\repository\org\springframework\boot\spring-boot\3.3.1\spring-boot-3.3.1.jar
        //...
    }

    /**
     * 9  getClassLoader 和 getContextClassLoader 方法
     */
    public static void test9(){
        ClassLoader classLoader = ClassUtil.getClassLoader();
        System.out.println("test9--classLoader==>"+classLoader);
        ClassLoader contextClassLoader = ClassUtil.getContextClassLoader();
        System.out.println("test9--contextClassLoader==>"+contextClassLoader);

        //结果：
        //test9--classLoader==>jdk.internal.loader.ClassLoaders$AppClassLoader@2b193f2d
        //test9--contextClassLoader==>jdk.internal.loader.ClassLoaders$AppClassLoader@2b193f2d
    }

    /**
     * 10 getDefaultValue
     */
    public static void test10(){
        //获取默认值

        Object defaultValue = ClassUtil.getDefaultValue(String.class);
        System.out.println("test10--defaultValue==>"+defaultValue);

        Object defaultValue1 = ClassUtil.getDefaultValue(Integer.class);
        System.out.println("test10--defaultValue1==>"+defaultValue1);

        Object defaultValue2 = ClassUtil.getDefaultValue(int.class);
        System.out.println("test10--defaultValue2==>"+defaultValue2);

        Object defaultValue3 = ClassUtil.getDefaultValue(boolean.class);
        System.out.println("test10--defaultValue3==>"+defaultValue3);

        Object defaultValue4 = ClassUtil.getDefaultValue(Boolean.class);
        System.out.println("test10--defaultValue4==>"+defaultValue3);

        //结果：
        //test10--defaultValue==>null
        //test10--defaultValue1==>null
        //test10--defaultValue2==>0
        //test10--defaultValue3==>false
        //test10--defaultValue4==>false
    }

}
