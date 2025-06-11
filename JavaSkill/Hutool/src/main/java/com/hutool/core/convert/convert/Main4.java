package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;

/**
 * 16进制（Hex）
 * @author lixuan
 * @Date 2024/12/18 15:08
 */
public class Main4 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1转换为16进制（Hex）字符串
     */
    public static void test1(){
        String a = "我是一个小小的可爱的字符串";

        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
        System.out.println("test1--hex==>"+hex);
    }

    /**
     * 2将16进制（Hex）字符串转为普通字符串
     */
    public static void test2(){
        String hex = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";

        //结果为："我是一个小小的可爱的字符串"
        //String raw = Convert.hexStrToStr(hex, CharsetUtil.CHARSET_UTF_8);

        //注意：在4.1.11之后hexStrToStr将改名为hexToStr
        String raw = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("test2--raw==>"+raw);
    }

}
