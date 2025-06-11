package com.hutool.core.tool;

import cn.hutool.core.util.RuntimeUtil;

import java.util.List;

/**
 * 命令行工具-RuntimeUtil
 * @author lixuan
 * @Date 2024/12/30 16:18
 */
public class Main14 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 命令行工具-RuntimeUtil
     */
    private static void test1() {
        String command = "cmd /c dir";
        String result = RuntimeUtil.execForStr(command);
        System.out.println("test1--result==>"+result);

        List<String> stringList = RuntimeUtil.execForLines(command);
        System.out.println("test1--stringList==>"+stringList);

        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println("test1--str==>"+str);
    }
}
