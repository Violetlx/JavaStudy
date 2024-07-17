package com.javase.day4.b;

import java.util.Arrays;

/**
 * 一维数组
 * @author lixuan
 * @Date 2024/6/12 14:22
 */
public class Main1 {
    public static void main(String[] args) {
        //假设出现一种情况，我们想要记录100个数字，是要定义100个变量的方式？是不是太麻烦了？这种情况下我们就可以使用数组来存放一组相同类型的数据
        int a = 10;
        int[] arr = {10,20,30,40,50};

        //一维数组
        //数组是相同类型的有序集合，数组可以代表任何相同类型的一组内容(包括引用类型和基本类型)
        //其中存放的每一个数据称为数组中的一个元素。

        //定义数组  类型[] 就表示这个是一个数组类型
        int[]  array;

        /**
         * 注意，数组类型比较特殊，它本身也是类，但是编程不可见（底层C++写的，在运行时动态创建）即使是基本类型的数组
         * 也是以对象的形式存在的，并不是基本数据类型。所以，我们要创建一个数组，同样需要使用 new 关键字
         */
        //在创建数组时，需要指定数组长度，也就是可以容纳多少个 int 元素
        int[] array1 = new int[10];
        array1[0] = 10;
        array1[1] = 20;
        array1[2] = 30;
        array1[3] = 40;
        array1[6] = 50;
        //同样是类，肯定是继承自Object的，所以说可以直接向上转型
        Object obj =array1;
        System.out.println(obj);

        /**
         * 数组定义的方式
         * <p>
         * 类型[] 变量名称 = new 类型[数组大小];
         * 类型 变量名称[] = new 类型[数组大小];  //支持C语言样式，但不推荐！
         * <p>
         * 类型[] 变量名称 = new 类型[]{...};  //静态初始化（直接指定值和大小）
         * 类型[] 变量名称 = {...};   //同上，但是只能在定义时赋值
         */

        Arrays.stream(array1).forEach(arr1->{
            System.out.print(arr1+" ");
        });

        System.out.println();

        System.out.println("----------------------------");

        //创建出来的数组每个位置上都有默认值，如果是引用类型，就是null ，如果是基本数据类型，就是0，或者是false，跟对象
        //成员变量的默认值是一样的，要访问数组中的某一个元素，我们可以：
        System.out.println("数组中的第一个元素："+array1[0]);

        /**
         * 注意数组的下标是从0开始的，不是从1开始的，所以说第一个元素的下标就是0，我们要访问第一个元素，那么直接输入0就行了
         * 但是注意千万别写成负数或者是超出范围了，否则会出现异常。
         */
        System.out.println("数组中的最后一个元素："+array1[array1.length-1]);

        System.out.println("----------------------------");

        //我们也可以使用这种方式为数组赋值
        int[] array2 = new int[10];
        //就像使用变量一样，是可以放在赋值运算符左边的，我们可以直接给对应下表位置的元素赋值
        array2[0] = 888;
        System.out.println("数组中的第一个元素为："+array2[0]);

        //因为数组本身也是一个对象，数组也是具有属性的，比如长度：
        System.out.println("数组的长度为："+array2.length);
        //注意这个length是在一开始就确定的，而且是final类型的，不允许进行修改，也就是说数组的长度一旦确定，不能随便修改，如果需要使用更大的数组，只能重新创建

        System.out.println("----------------------------");

        String[] array3 = new String[]{"a","b","c"};
        Arrays.stream(array3).forEach(arr3->{
            System.out.print(arr3+" ");
        });

        System.out.println();

        System.out.println("----------------------------");

        //循环访问数组元素
        for (int i = 0; i < array1.length-1; i++) {
            System.out.print(array1[i]+" ");
        }

        System.out.println();
        System.out.println("----------------------------");

        //比较两个数组内容是否相等
        int[] array4 = {1,2,3,4,5};
        int[] array5 = {1,2,3,4,5};
        int[] array6 = array4.clone();

        boolean flag = false;

        for (int i = 0; i < array4.length-1; i++) {
            flag = array4[i] == array5[i];
        }
        System.out.println(flag);

        for (int i = 0; i < array4.length - 1; i++) {
            flag = array4[i] == array6[i];
        }
        System.out.println(flag);

        System.out.println("----------------------------");

        //有时候为了方便，我们可以使用简化版的for语句 foreach 语法来便利数组中的每一个元素
        for (int i : array4.clone()) {
            System.out.print(i+" ");
        }

        //是不是感觉这种写法更加简洁？只不过这仅仅是语法糖而已，编译之后依然是跟上面一样老老实实的在遍历

        System.out.println();
        System.out.println("----------------------------");

        //这里需要特别说一下，对于基本类型的数组来说，是不支持自动装箱和拆箱的
        int[] arr2 = new int[10];
//        Integer[] test = arr2;

//        Object[] test = arr2;

        //还有，由于基本数据类型和引用数据类型不同，所以说int类型的数组不能被Object类型的数组变量接收的

        //但是如果是引用类型的话，是可以的
        String[] arr3 = new String[10];
        //数组同样支持向上转型
        Object[] obj1 = arr3;

        Object[] arr4 = new Object[10];
        //也支持向下转型
        String[] arr5 = (String[]) arr4;


    }
}
