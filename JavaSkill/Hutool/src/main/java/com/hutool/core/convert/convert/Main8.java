package com.hutool.core.convert.convert;

import cn.hutool.core.convert.Convert;

/**
 * 金额大小写转换
 * @author lixuan
 * @Date 2024/12/18 15:45
 */
public class Main8 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 金额大小写转换
     */
    public static void test1() {
        double a = 67556.32;

        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
        System.out.println("test1--digitUppercase==>"+digitUppercase);
    }
}
