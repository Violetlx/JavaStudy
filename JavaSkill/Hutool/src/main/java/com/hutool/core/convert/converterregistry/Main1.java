package com.hutool.core.convert.converterregistry;

import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.lang.Assert;

/**
 * 自定义转换类型
 * @author lixuan
 * @Date 2024/12/18 17:00
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }


    /**
     * 自定义类型转换
     */
    public static void test1() {
        int a = 3423;
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        String result = converterRegistry.convert(String.class, a);
        System.out.println("test1--result==>"+result);
        Assert.equals("3423", result);
    }

    /**
     * 自定义转换器
     */
    public static void test2() {
        //2.注册转换器
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        //此处做为示例自定义String转换，因为Hutool中已经提供String转换，请尽量不要替换
        //替换可能引发关联转换异常（例如覆盖String转换会影响全局）
        converterRegistry.putCustom(String.class, CustomConverter.class);

        //3.执行转换
        int a = 454553;
        String result = converterRegistry.convert(String.class, a);
        System.out.println("test2--result==>"+result);
        Assert.equals("Custom: 454553", result);
    }
}
