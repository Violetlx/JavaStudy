package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

/**
 * Unicode和字符串转换
 * @author lixuan
 * @Date 2024/12/18 15:14
 */
public class Main5 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * Unicode和字符串转换
     */
    public static void test1() {
        String a = "我是一个小小的可爱的字符串";

        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
        System.out.println("test1--unicode==>"+unicode);

        //结果为："我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
        System.out.println("test1--raw==>"+raw);
    }
}
