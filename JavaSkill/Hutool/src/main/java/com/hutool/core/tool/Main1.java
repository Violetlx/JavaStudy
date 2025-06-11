package com.hutool.core.tool;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;

/**
 * 字符串工具-StrUtil
 * @author lixuan
 * @Date 2024/12/25 10:55
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();
        System.out.println("---------------------------");
        test5();
        System.out.println("---------------------------");
        test6();
    }

    /**
     * 1 hasBlank、hasEmpty方法
     */
    public static void test1(){
        //这两个方法的区别是hasEmpty只判断是否为null或者空字符串（""），hasBlank则会把不可见字符也算做空，isEmpty和isBlank同理。
        String str1 = "  ";
        String str2 = "  ";
        boolean hasBlank = StrUtil.hasBlank(str1);
        boolean hasEmpty = StrUtil.hasEmpty(str2);
        System.out.println("test1--hasBlank==>"+hasBlank);
        System.out.println("test1--hasEmpty==>"+hasEmpty);

        //结果：
        //test1--hasBlank==>true
        //test1--hasEmpty==>false
    }

    /**
     * 2 removePrefix、removeSuffix 方法
     */
    private static void test2(){
        //fileName -> pretty_girl
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg",".jpg");
        System.out.println("test2--fileName==>"+fileName);
        //pretty_girl -> pretty_girl
        String fileName2 = StrUtil.removePrefix("pretty_girl.jpg","pretty_");
        System.out.println("test2--fileName2==>"+fileName2);
        // 忽略大小写
        // pretty_girl -> pretty_girl
        String fileName3 = StrUtil.removePrefixIgnoreCase("Pretty_girl.jpg","PrETTY_");
        System.out.println("test2--fileName3==>"+fileName3);
        // pretty_girl -> pretty_girl
        String fileName4 = StrUtil.removeSuffixIgnoreCase("pretty_girl.jpg",".JPG");
        System.out.println("test2--fileName4==>"+fileName4);

        //结果：
        //test2--fileName==>pretty_girl
        //test2--fileName2==>girl.jpg
        //test2--fileName3==>girl.jpg
        //test2--fileName4==>pretty_girl
    }

    /**
     * 3 sub方法
     */
    private static void test3(){
        String str = "abcdefgh";
        //strSub1 -> c
        String strSub1 = StrUtil.sub(str, 2, 3);
        System.out.println("test3--strSub1==>"+strSub1);
        //strSub2 -> cde
        String strSub2 = StrUtil.sub(str, 2, -3);
        System.out.println("test3--strSub2==>"+strSub2);
        //strSub2 -> c
        String strSub3 = StrUtil.sub(str, 3, 2);
        System.out.println("test3--strSub3==>"+strSub3);

        //需要注意的是，-1表示最后一个字符，但是因为sub方法的结束index是不包含的，因此传-1最后一个字符是取不到的：
        String strSub4 = StrUtil.sub(str, 2, -1);
        System.out.println("test3--strSub4==>"+strSub4);

        //如果想截取后半段，可以使用StrUtil.subSuf方法。
        // StrUtil.subSuf
        String strSub5 = StrUtil.subSuf(str, 2);
        System.out.println("test3--strSub5==>"+strSub5);

        // 截取某字符之后的字符串
        String subAfter = StrUtil.subAfter(str, "b", true);
        System.out.println("test3--subAfter==>"+subAfter);

        // 截取某字符之前的字符串
        String subBefore = StrUtil.subBefore(str, "b", true);
        System.out.println("test3--subBefore==>"+subBefore);

        //如果设置为 true，表示将从 第一个匹配到的字符 之后开始截取子字符串，并且不包括匹配的字符本身。
        //如果设置为 false，表示将从 最后一个匹配到的字符 之后开始截取子字符串，并且不包括匹配的字符本身。

        //结果：
        //test3--strSub1==>c
        //test3--strSub2==>cde
        //test3--strSub3==>c
        //test3--strSub4==>cdefg
        //test3--strSub5==>cdefgh
        //test3--subAfter==>cdefgh
        //test3--subBefore==>a

    }

    /**
     * 4 str、bytes 方法
     */
    private static void test4(){
        String str = "abcdefgh张三";
        String str1 = StrUtil.str(str.getBytes(), "gbk");
        System.out.println("test4--str1==>"+str1);

        String str2 = StrUtil.str(str.getBytes(), "UTF-8");
        System.out.println("test4--str2==>"+str2);

        byte[] bytes = StrUtil.bytes(str);
        System.out.println("test4--bytes==>"+ Arrays.toString(bytes));

        String str3 = StrUtil.str(bytes, "UTF-8");
        System.out.println("test4--str3==>"+str3);

        //结果：
        //test4--str1==>abcdefgh寮犱笁
        //test4--str2==>abcdefgh张三
        //test4--bytes==>[97, 98, 99, 100, 101, 102, 103, 104, -27, -68, -96, -28, -72, -119]
        //test4--str3==>abcdefgh张三
    }


    /**
     * 5 format 方法
     */
    private static void test5(){
        String template = "{}爱{}，就像老鼠爱大米";
        //str -> 我爱你，就像老鼠爱大米
        String str = StrUtil.format(template, "我", "你");
        System.out.println("test5--str==>"+str);

        //结果：
        //test5--str==>我爱你，就像老鼠爱大米
    }

    /**
     * 6 定义的一些常量
     */
    private static void test6(){
        System.out.println("test6--StrUtil.CRLF==>"+StrUtil.CRLF);
        System.out.println("test6--StrUtil.CR==>"+StrUtil.CR);
        System.out.println("test6--StrUtil.LF==>"+StrUtil.LF);
        System.out.println("test6--StrUtil.TAB==>"+StrUtil.TAB);
        System.out.println("test6--StrUtil.SPACE==>"+StrUtil.SPACE);
        System.out.println("test6--StrUtil.UNDERLINE==>"+StrUtil.UNDERLINE);
        System.out.println("test6--StrUtil.DOT==>"+StrUtil.DOT);
        System.out.println("test6--StrUtil.COMMA==>"+StrUtil.COMMA);
    }
}
