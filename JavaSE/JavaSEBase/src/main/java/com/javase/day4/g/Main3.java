package com.javase.day4.g;

/**
 * 青蛙跳台阶问题
 * @author lixuan
 * @Date 2024/6/14 16:13
 */
public class Main3 {
    public static void main(String[] args) {
        //青蛙跳台阶问题
        int n = 5;
        System.out.println(jump(n));
    }
    public static int jump(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
