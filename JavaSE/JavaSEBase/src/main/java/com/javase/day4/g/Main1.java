package com.javase.day4.g;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author lixuan
 * @Date 2024/6/14 15:53
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 2, 9, 0, 6, 1, 8, 4};

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
