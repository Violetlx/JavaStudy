package com.hutool.core.tool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;

/**
 * 16进制工具-HexUtil
 * @author lixuan
 * @Date 2024/12/25 14:27
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 16进制工具-HexUti
     */
    private static void test1() {
        String str = "我是一个字符串";

        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        System.out.println("test1--hex==>"+hex);

        //hex是：
        //e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2

        String decodedStr = HexUtil.decodeHexStr(hex);
        System.out.println("test1--decodedStr==>"+decodedStr);

        //解码后与str相同

        //结果：
        //test1--hex==>e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2
        //test1--decodedStr==>我是一个字符串

    }
}
