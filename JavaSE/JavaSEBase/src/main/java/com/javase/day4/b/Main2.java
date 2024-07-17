package com.javase.day4.b;

/**
 * 多维数组
 * @author lixuan
 * @Date 2024/6/12 15:00
 */
public class Main2 {
    public static void main(String[] args) {
        int[][] arr = new int[2][10];
        /**
         * arr这个数组中一共有2个元素，每个元素都是一个存放10个元素的数组，所以说最后看起来就像是一个矩阵一样。甚至可以继续套娃
         * 将其变成一个三维数组，也就是存放数组的数组的数组。
         */

        //一个三行两列的数组
        int[][] arr1 = { {1, 2}, {3, 4}, {5, 6}};
        //访问第三行第二列的元素
        System.out.println(arr1[2][1]);

        System.out.println("----------------------");

        //在访问多维数组时，我们需要使用多次[]运算符来得到对应位置的元素，如果我们要遍历多为数组的话，那么就需要多次嵌套循环
        int[][] arr2 = { {1, 2}, {3, 4}, {5, 6}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr1[i][j]+" ");
            }
        }

    }
}
