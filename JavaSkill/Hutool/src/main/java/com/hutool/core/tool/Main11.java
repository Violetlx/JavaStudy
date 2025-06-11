package com.hutool.core.tool;

import cn.hutool.core.swing.clipboard.ClipboardUtil;


/**
 * 剪贴板工具-ClipboardUtil
 * @author lixuan
 * @Date 2024/12/30 9:01
 */
public class Main11 {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 针对文本
     */
    public static void test2(){
        // 先右键复制内容到剪贴板再测试

        //获取剪贴板内容
        String str = ClipboardUtil.getStr();
        System.out.println("test2--str==>"+str);

        //设置剪贴板内容
        ClipboardUtil.setStr("hello world");

        //获取剪贴板内容
        String str1 = ClipboardUtil.getStr();
        System.out.println("test2--str1==>"+str1);

        //结果：
        //test2--str==>hello world
        //test2--str1==>hello world
    }
}
