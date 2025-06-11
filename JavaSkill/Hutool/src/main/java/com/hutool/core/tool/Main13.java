package com.hutool.core.tool;

import cn.hutool.core.util.EnumUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 枚举工具-EnumUtil
 * @author lixuan
 * @Date 2024/12/30 15:32
 */
public class Main13 {

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
    }

    /**
     * 1 getNames
     */
    public static void test1(){
        //获取枚举的所有名称，返回数组
        List<String> names = EnumUtil.getNames(TestEnum.class);
        System.out.println("test1--names==>"+names);

        //结果：
        //test1--names==>[TEST1, TEST2, TEST3]
    }

    /**
     * 2 getFieldValues
     */
    public static void test2(){
        //获取枚举的所有字段值，返回数组
        List<Object> type = EnumUtil.getFieldValues(TestEnum.class, "type");
        System.out.println("test2--type==>"+type);

        //结果：
        //test2--fieldValues==>[type1, type2, type3]
    }

    /**
     * 3 getBy
     */
    public static void test3(){
        //根据字段值获取枚举 根据传入 Lambda 和值 获得对应枚举。
        TestEnum testEnum = EnumUtil.getBy(TestEnum::ordinal,1);
        System.out.println("test3--testEnum==>"+testEnum);

        //结果：
        //test3--testEnum==>TEST1
    }

    /**
     * 4 getFieldBy
     */
    public static void test4(){
        //根据字段值获取枚举 根据传入 Lambda 和值 获得对应枚举。
        TestEnum testEnum = EnumUtil.getBy(TestEnum::getType,"type1");
        System.out.println("test4--testEnum==>"+testEnum);

        //结果：
        //test4--testEnum==>TEST1
    }

    /**
     * 5 getEnumMap
     */
    public static void test5(){
        //获取枚举的所有枚举对象，返回Map
        LinkedHashMap<String, TestEnum> enumMap = EnumUtil.getEnumMap(TestEnum.class);
        System.out.println("test5--enumMap==>"+enumMap);

        //结果：
        //test5--enumMap==>{TEST1=TEST1, TEST2=TEST2, TEST3=TEST3}
    }

    /**
     * 6 getNameFieldMap
     */
    public static void test6(){
        //获取枚举的所有名称和字段值，返回Map
        Map<String, Object> type = EnumUtil.getNameFieldMap(TestEnum.class, "type");
        System.out.println("test6--type==>"+type);

        //结果：
        //test6--type==>{TEST1=type1, TEST2=type2, TEST3=type3}
    }
}
