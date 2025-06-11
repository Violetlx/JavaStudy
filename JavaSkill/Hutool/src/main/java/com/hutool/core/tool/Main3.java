package com.hutool.core.tool;

import cn.hutool.core.util.EscapeUtil;

/**
 * Escape工具-EscapeUtil
 * @author lixuan
 * @Date 2024/12/25 15:06
 */
public class Main3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * Escape工具-EscapeUtil
     */
    private static void test1() {
        String str = "我是一个字符串 * @ - _ + . /";

        String escape = EscapeUtil.escape(str);
        System.out.println("test1--escape==>"+escape);

        //escape是：
        //%E6%88%91%E6%98%AF%E4%B8%80%E4%B8%AA%E5%AD%97%E7%AC%A6%E4%B8%B2

        String unescape = EscapeUtil.unescape(escape);
        System.out.println("test1--unescape==>"+unescape);

        String safeUnescape = EscapeUtil.safeUnescape(str);
        System.out.println("test1--safeUnescape==>"+safeUnescape);

        //结果：
        //test1--escape==>%u6211%u662f%u4e00%u4e2a%u5b57%u7b26%u4e32%20*%20@%20-%20_%20+%20.%20/
        //test1--unescape==>我是一个字符串 * @ - _ + . /
        //test1--safeUnescape==>我是一个字符串 * @ - _ + . /
    }
}
