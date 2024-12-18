package com.algorithms.day1;

/**
 * 二分查找基础版
 * @author lixuan
 * @Date 2024/10/29 11:39
 */
public class BinarySearch {

    /**
     * 二分查找基础版
     * Params: a - 待查找的升序数组
     *        target - 要查找的目标值
     *
     * Returns:
     *        找到则返回索引
     *        找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        // 设置指针和初值
        int i = 0 , j = a.length - 1;
        // 范围内有东西
        while (i <= j) {
            // 确定中间索引 M int Java 中会自动取整
            int m = (i + j) / 2;
            // 目标小于中间值，也就是目标在中间值的左边
            if (target < a[m]) {
                // 就让 j 的范围缩小
                j = m - 1;
            } else if (target > a[m]) {
                // 目标大于中间值，也就是目标在中间值的右边
                i = m + 1;
            } else {
                // 找到了
                return m;
            }
        }
        return -1;
    }

    /*
       问题1：为什么是 i<=j 而不是 i<j？
          i==j 意味着 i,j 它们指向的元素也会参与比较
          i<j 只意味着 m 指向的元素参与比较

       问题2：(i + j) / 2 有没有问题？

     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearchBasic(a, 5);
        System.out.println(index);
    }
}
