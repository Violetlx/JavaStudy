package com.javase.day4.f;

import java.util.Arrays;

/**
 * 数组工具类
 * @author lixuan
 * @Date 2024/6/14 15:44
 */
public class Main2 {
    public static void main(String[] args) {
        //数组工具类Arrays

        //这个类也是java.util包下类，它用于便捷操作数组，比如我们想要打印数组，可以直接通过toString方法转换字符串：
        int[] arr = new int[]{1, 4, 5, 8, 2, 0, 9, 7, 3, 6};
        System.out.println(Arrays.toString(arr));

        //排序
        int[] arr1 = new int[]{1, 4, 5, 8, 2, 0, 9, 7, 3, 6};
        //可以对数组进行排序，将所有的元素按照从小到大的顺序排放
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        //填充
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 66);
        System.out.println(Arrays.toString(arr2));

        //拷贝
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        //也可以只拷贝某个范围内的内容
        int[] target = Arrays.copyOf(arr3, 5);
        //拷贝数组的全部内容，并生成一个新的数组对象
        System.out.println(Arrays.toString(target));
        System.out.println(arr3 == target);

        int[] arr4 = new int[]{1, 2, 3, 4, 5};
        //二分搜索仅适用于有序数组
        System.out.println(Arrays.binarySearch(arr4, 5));

        System.out.println("-----------------------");

        //那要是现在我们使用的是多维数组呢？因为现在数组里面的每个元素就是一个数组，所以说toString会出现些问题：
        int[][] array = new int[][]{{2, 8, 4, 1}, {9, 2, 0, 3}};
        //[[I@37a71e93, [I@7e6cbb7a]
        System.out.println(Arrays.toString(array));

        //只不过别担心，Arrays也支持对多维数组进行处理：
        int[][] array1 = new int[][]{{2, 8, 4, 1}, {9, 2, 0, 3}};
        //deepToString方法可以对多维数组进行打印
        System.out.println(Arrays.deepToString(array1));

        //同样的，因为数组本身没有重写equals方法，所以说无法判断两个不同的数组对象中的每一个元素是否相同
        //Arrays也为一维数组和多维数组提供了相等判断的方法
        int[][] a = new int[][]{{2, 8, 4, 1}, {9, 2, 0, 3}};
        int[][] b = new int[][]{{2, 8, 4, 1}, {9, 2, 0, 3}};
        //equals仅适用于一维数组
        System.out.println(Arrays.equals(a, b));
        //对于多维数组，需要使用deepEquals来进行深层次判断
        System.out.println(Arrays.deepEquals(a, b));

    }
}
