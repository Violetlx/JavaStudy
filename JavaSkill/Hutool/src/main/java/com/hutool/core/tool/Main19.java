package com.hutool.core.tool;

import cn.hutool.core.util.ReferenceUtil;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 引用工具-ReferenceUtil
 * @author lixuan
 * @Date 2025/1/14 15:22
 */
public class Main19 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.创建不同类型的引用对象
     */
    private static void test1() {
        String strongReference = new String("Strong Reference");

        // 创建软引用
        Reference<String> softReference = ReferenceUtil.create(ReferenceUtil.ReferenceType.SOFT, strongReference);
        System.out.println("软引用内容: " + softReference.get());

        // 创建弱引用
        Reference<String> weakReference = ReferenceUtil.create(ReferenceUtil.ReferenceType.WEAK, strongReference);
        System.out.println("弱引用内容: " + weakReference.get());

        // 创建虚引用
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        Reference<String> phantomReference = ReferenceUtil.create(ReferenceUtil.ReferenceType.PHANTOM, strongReference, queue);
        System.out.println("虚引用内容: " + phantomReference.get());

        //结果：
        //软引用内容: Strong Reference
        //弱引用内容: Strong Reference
        //虚引用内容: null
    }

}
