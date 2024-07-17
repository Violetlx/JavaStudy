package com.javase.day2.b;

/**
 * 字符型
 * @author lixuan
 */
public class Main3 {
    public static void main(String[] args) {
        //字符型要用单引号，且只能表示一个字符

        //cha字符型 （16个bit，也就是2字节，它不带符号）范围是0 ~ 65535
        char c = 'A';
        //字符型变量c的值是A
        System.out.println(c);

        //ASCII码：
        char c1 = 65;
        //ASCII码65对应的字符 A
        System.out.println(c1);

        //中文字符 使用unicode编码  UTF-8、UTF-16 是“编码规则”
        char c2 = '中';
        System.out.println(c2);

        //使用int类型接收字符类型常量值可以直接转换为对应的编码
        int a = '淦';
        System.out.println(a);

        char c3 = (char) a;
        System.out.println(c3);

        System.out.println("------------------------------------");

        //字符串 不是基本类型是对象类型 可以为空
        String str = "abc";
        System.out.println(str);

        String str1 = null;
        String str2 = "";

        String str3 = "你干嘛哎哟~";
        System.out.println(str3);

    }
}
