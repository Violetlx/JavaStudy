package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.List;

/**
 * 其他类型转换
 * @author lixuan
 * @Date 2024/12/18 14:50
 */
public class Main2 {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 2.泛型类型
     */
    public static void test1() {
        Object[] a = { "a", "你", "好", "", 1 };
        List<String> list = Convert.convert(new TypeReference<List<String>>() {}, a);
        System.out.println("test1--list==>"+list);

        //结果：
        //test1--list==>[a, 你, 好, , 1]
    }
}
