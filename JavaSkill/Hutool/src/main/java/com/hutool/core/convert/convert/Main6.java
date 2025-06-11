package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.CharsetUtil;

/**
 * 编码转换
 * @author lixuan
 * @Date 2024/12/18 15:24
 */
public class Main6 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.编码转换
     */
    public static void test1(){
        String a = "我不是乱码";

        //转换后result为乱码
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        System.out.println("test1--result==>"+result);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        System.out.println("test1--raw==>"+raw);
        Assert.equals(raw, a);
    }
}
