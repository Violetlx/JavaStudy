package com.javase.day4.g;

import java.util.Scanner;

/**
 * 回文串判断
 * @author lixuan
 * @Date 2024/6/17 14:33
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str1 = new StringBuilder(str).reverse().toString();
        if (str.equals(str1)) {
            System.out.println("是回文串");
        } else {
            System.out.println("不是回文串");
        }
    }
}
