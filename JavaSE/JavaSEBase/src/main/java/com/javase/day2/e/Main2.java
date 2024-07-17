package com.javase.day2.e;

/**
 * 九九乘法表
 * @author lixuan
 * @Date 2024/5/28 15:45
 */
public class Main2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
