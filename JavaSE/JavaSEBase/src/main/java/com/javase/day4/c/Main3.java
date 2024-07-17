package com.javase.day4.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author lixuan
 * @Date 2024/6/12 16:55
 */
public class Main3 {
    public static void main(String[] args) {
        /**
         * 我们想要实现这样一个功能，对于给定的字符串进行判断，如果字符串符合我们的规则，那么就返回为真，否则返回为假
         *
         * //matches方法用于对给定正则表达式进行匹配，匹配成功返回true，否则返回false
         */

        /**
         * 1、字符类：
         * []：字符类，表示匹配方括号内的任一字符。
         * ^：在字符类内部使用，表示否定，即不匹配方括号内的任何字符。
         * -：在字符类内部使用，表示范围，例如 [a-z] 匹配小写字母 a 到 z。
         * <p>
         *
         * 2、限定符：
         * *：匹配前一个元素零次或多次。
         * +：匹配前一个元素一次或多次。
         * ?：匹配前一个元素零次或一次。
         * {n}：匹配前一个元素恰好 n 次。
         * {n,}：匹配前一个元素至少 n 次。
         * {n,m}：匹配前一个元素至少 n 次，但不超过 m 次。
         * <p>
         *
         * 3、定位符：
         * ^：匹配输入字符串的开始位置。
         * $：匹配输入字符串的结束位置。
         * \b：匹配单词的边界。
         * \B：匹配非单词边界。
         * <p>
         *
         * 4、转义字符：
         * \：转义下一个字符，使其具有特殊意义。
         * <p>
         *
         * 5、其他特殊字符：
         * ()：分组，用于限定操作符的范围。
         * |：或操作符，用于匹配多个表达式中的一个。
         */


        // 将要验证的QQ号
        String qqNumber = "123456789";

        if (isValidQQNumber(qqNumber)) {
            System.out.println("QQ号符合规范。");
        } else {
            System.out.println("QQ号不符合规范。");
        }

        System.out.println("------------------------");

        // 将要验证的邮箱
        String email = "test@example.com";

        if (isValidEmail(email)) {
            System.out.println("邮箱地址符合规范。");
        } else {
            System.out.println("邮箱地址不符合规范。");
        }

    }

    public static boolean isValidQQNumber(String qqNumber) {
        // QQ号正则表达式
        String qqRegex = "[1-9][0-9]{4,14}";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(qqRegex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(qqNumber);

        // 判断是否匹配
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        // Email正则表达式
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(emailRegex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(email);

        // 判断是否匹配
        return matcher.matches();
    }

}
