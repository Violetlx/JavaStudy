package com.javase.day4.g;

import static java.util.Arrays.binarySearch;

/**
 * 二分搜索算法
 * @author lixuan
 * @Date 2024/6/14 15:59
 */
public class Main2 {
    public static void main(String[] args) {
        //二分搜索要在有序数组中搜索
        int[] arr = {1, 3, 4, 6, 7, 8, 10, 11, 13, 15};
        int target = 15;
        int index = binarySearch(arr, target);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了，下标为：" + index);
        }

        System.out.println("------------");

        System.out.println(binarySearch1(arr, target));
    }

    public static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
