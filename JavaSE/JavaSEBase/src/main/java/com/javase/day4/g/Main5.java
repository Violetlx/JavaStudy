package com.javase.day4.g;

/**
 * 汉诺塔求解
 * @author lixuan
 * @Date 2024/6/17 14:35
 */
public class Main5 {
    public static void main(String[] args) {
        hanoi(2,'A','B','C');
    }
    public static void hanoi(int n,char a,char b,char c) {
        if(n == 1)
        {
            System.out.println("将圆盘从" + a + "移动到" + c);
        }
        else
        {
            hanoi(n-1,a,c,b);
            System.out.println("将圆盘从" + a + "移动到" + c);
            hanoi(n-1,b,a,c);
        }
    }
}
