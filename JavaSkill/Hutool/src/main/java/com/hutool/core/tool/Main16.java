package com.hutool.core.tool;

import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ArrayUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/**
 * 数组工具-ArrayUtil
 * @author lixuan
 * @Date 2025/1/8 15:21
 */
public class Main16 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();
        System.out.println("---------------------------");
        test5();
        System.out.println("---------------------------");
        test6();
        System.out.println("---------------------------");
        test7();
        System.out.println("---------------------------");
        test8();
        System.out.println("---------------------------");
        test9();
        System.out.println("---------------------------");
        test10();
        System.out.println("---------------------------");
        test11();
        System.out.println("---------------------------");
        test12();
        System.out.println("---------------------------");
        test13();
        System.out.println("---------------------------");
        test14();
        System.out.println("---------------------------");
        test15();
    }

    /**
     * 1.判空
     */
    private static void test1(){
        //判空
        int[] a = {};
        int[] b = null;
        boolean a1 = ArrayUtil.isEmpty(a);
        boolean b1 = ArrayUtil.isEmpty(b);
        System.out.println("test1--a1==>"+a1);
        System.out.println("test1--b1==>"+b1);

        //判非空
        int[] c = {1,2,3};
        boolean c1 = ArrayUtil.isNotEmpty(c);
        System.out.println("test1--c1==>"+c1);

        //结果：
        //test1--a1==>true
        //test1--b1==>true
        //test1--c1==>true
    }

    /**
     * 2.新建泛型数组
     */
    private static void test2(){
        //新建泛型数组
        String[] stringNewArray = ArrayUtil.newArray(String.class,3);
        stringNewArray[0] = "a";
        stringNewArray[1] = "b";
        stringNewArray[2] = "c";
        System.out.println("test2--newArray==>"+ Arrays.toString(stringNewArray));

        Integer[] intNewArray = ArrayUtil.newArray(Integer.class, 5);
        intNewArray[0] = 1;
        intNewArray[1] = 2;
        intNewArray[2] = 3;
        intNewArray[3] = 4;
        System.out.println("test2--objects==>"+ Arrays.toString(intNewArray));

        //结果：
        //test2--newArray==>[a, b, c]
        //test2--objects==>[1, 2, 3, 4, null]

    }

    /**
     * 3.调整大小
     */
    private static void test3(){
        //使用 `ArrayUtil.resize` 方法生成一个新的重新设置大小的数组
        String[] stringArray = {"a","b","c"};
        String[] stringResizeArray = ArrayUtil.resize(stringArray, 5);
        System.out.println("test3--stringResizeArray==>"+ Arrays.toString(stringResizeArray));

        Integer[] intArray = {1,2,3,4,5};
        Integer[] intResizeArray = ArrayUtil.resize(intArray, 3);
        System.out.println("test3--intResizeArray==>"+ Arrays.toString(intResizeArray));

        //结果：
        //test3--stringResizeArray==>[a, b, c, null, null]
        //test3--intResizeArray==>[1, 2, 3]
    }

    /**
     * 4.合并数组
     */
    private static void test4(){
        //使用 `ArrayUtil.addAll` 方法合并两个数组
        String[] stringArray = {"a","b","c"};
        String[] stringArray2 = {"1","2","3"};
        String[] stringAddAllArray = ArrayUtil.addAll(stringArray, stringArray2);
        System.out.println("test4--stringAddAllArray==>"+ Arrays.toString(stringAddAllArray));

        Integer[] intArray = {1,2,3,4,5};
        Integer[] intArray2 = {6,7,8,9,10};
        Integer[] intAddAllArray = ArrayUtil.addAll(intArray, intArray2);
        System.out.println("test4--intAddAllArray==>"+ Arrays.toString(intAddAllArray));

        //结果：
        //test4--stringAddAllArray==>[a, b, c, 1, 2, 3]
        //test4--intAddAllArray==>[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    /**
     * 5.克隆
     */
    private static void test5(){
        //泛型数组调用原生克隆
        Integer[] b = {1,2,3};
        Integer[] cloneB = ArrayUtil.clone(b);
        //判断是否是同一个对象
        System.out.println("test5--b==>"+ (b == cloneB));
        //判断是否等值
        System.out.println("test5--b==>"+ Arrays.equals(b, cloneB));
        System.out.println("test5--cloneB==>"+ Arrays.toString(cloneB));

        //非泛型数组（原始类型数组）调用第二种重载方法
        int[] a = {1,2,3};
        int[] clone = ArrayUtil.clone(a);
        //判断是否是同一个对象
        System.out.println("test5--a==>"+ (a == clone));
        //判断是否等值
        System.out.println("test5--a==>"+ Arrays.equals(a, clone));
        System.out.println("test5--clone==>"+ Arrays.toString(clone));

        //结果：
        //test5--b==>false
        //test5--b==>true
        //test5--cloneB==>[1, 2, 3]
        //test5--a==>false
        //test5--a==>true
        //test5--clone==>[1, 2, 3]
    }

    /**
     * 6.有序列表生成
     */
    private static void test6(){
        //使用 `ArrayUtil.range` 方法生成有序列表
        //生成从 start 到 end 的整数列表，步长为 step 2
        int[] ints = ArrayUtil.range(1, 10, 2);
        System.out.println("test6--ints==>"+ Arrays.toString(ints));

        //生成从 start 到 end 的整数列表，步长为 step 3
        int[] ints1 = ArrayUtil.range(1, 10, 3);
        System.out.println("test6--ints1==>"+ Arrays.toString(ints1));

        //结果：
        //test6--ints==>[1, 3, 5, 7, 9]
        //test6--ints1==>[1, 4, 7]
    }

    /**
     * 7.拆分数组
     */
    private static void test7(){
        //ArrayUtil.split
        byte[] byteArray = {1,2,3,4,5,6,7,8,9,10};
        byte[][] byteSplitArray = ArrayUtil.split(byteArray, 3);
        for (int i = 0; i < byteSplitArray.length; i++) {
            System.out.println("test7--byteArray"+i+"==>"+ Arrays.toString(byteSplitArray[i]));
        }

        //结果：
        //test7--byteArray0==>[1, 2, 3]
        //test7--byteArray1==>[4, 5, 6]
        //test7--byteArray2==>[7, 8, 9]
        //test7--byteArray3==>[10]
    }

    /**
     * 8.过滤
     */
    private static void test8(){
        //使用 `ArrayUtil.filter` 方法过滤数组
        String[] stringArray = {"a","b","c","d","e","f","g","h","i","j"};
        String[] stringFilterArray = ArrayUtil.filter(stringArray,
                s -> "a".equals(s) || "b".equals(s) || "c".equals(s));
        System.out.println("test8--stringFilterArray==>"+ Arrays.toString(stringFilterArray));

        //过滤数组，只保留偶数
        Integer[] intArray = {1,2,3,4,5,6,7,8,9,10};
        Integer[] intFilterArray = ArrayUtil.filter(intArray,
                i -> i % 2 == 0);
        System.out.println("test8--intFilterArray==>"+ Arrays.toString(intFilterArray));

        //对已有数组编辑，获得编辑后的值
        Integer[] a = {1, 2, 3, 4, 5, 6};
        // [1, 20, 3, 40, 5, 60]
        Integer[] b = ArrayUtil.edit(a,
                i -> i % 2 == 0 ? i * 10 : i);
        System.out.println("test8--b==>"+ Arrays.toString(b));

        //结果：
        //test8--stringFilterArray==>[a, b, c]
        //test8--intFilterArray==>[2, 4, 6, 8, 10]
        //test8--b==>[1, 20, 3, 40, 5, 60]
    }

    /**
     * 9.编辑
     */
    private static void test9(){
        //对已有数组编辑，获得编辑后的值
        Integer[] a = {1, 2, 3, 4, 5, 6};
        // [1, 20, 3, 40, 5, 60]
        Integer[] b = ArrayUtil.edit(a,
                i -> i % 2 == 0 ? i * 10 : i);
        System.out.println("test9--b==>"+ Arrays.toString(b));

        //结果：
        //test9--b==>[1, 20, 3, 40, 5, 60]
    }

    /**
     * 10.zip
     */
    private static void test10(){
        //使用 `ArrayUtil.zip` 方法将两个数组合并成一个数组
        //`ArrayUtil.zip` 方法传入两个数组，第一个数组为 key
        //第二个数组对应位置为 value ，此方法在 Python 中为 zip() 函数
        String[] stringArray = {"a","b","c"};
        Integer[] intArray = {1,2,3};
        Map<String, Integer> zip = ArrayUtil.zip(stringArray, intArray);
        System.out.println("test10--zip==>"+ zip);

        //结果：
        //test10--zip==>{a=1, b=2, c=3}
    }

    /**
     * 11.是否包含元素
     */
    private static void test11(){
        String[] stringArray = {"a","b","c"};
        boolean contains = ArrayUtil.contains(stringArray, "a");
        System.out.println("test11--contains==>"+ contains);
        contains = ArrayUtil.contains(stringArray, "d");
        System.out.println("test11--contains==>"+ contains);

        //结果：
        //test11--contains==>true
        //test11--contains==>false
    }

    /**
     * 12.包装和拆包
     */
    private static void test12(){
        //使用 `ArrayUtil.wrap` 方法将数组包装为对象数组
        int[] intArray = {1,2,3};
        Integer[] integers = ArrayUtil.wrap(intArray);
        System.out.println("test12--objectArray==>"+ Arrays.toString(integers));

        //使用 `ArrayUtil.unWrap` 方法将对象数组拆包为原始数组
        Integer[] integerArray = {1,2,3};
        int[] ints = ArrayUtil.unWrap(integerArray);
        System.out.println("test12--intArray==>"+ Arrays.toString(ints));

        //结果：
        //test12--objectArray==>[1, 2, 3]
        //test12--intArray==>[1, 2, 3]
    }

    /**
     * 13.判断对象是否为数组
     */
    private static void test13(){
        boolean isArray = ArrayUtil.isArray(new int[]{1,2,3});
        System.out.println("test13--isArray==>"+ isArray);

        isArray = ArrayUtil.isArray(new Integer[]{1,2,3});
        System.out.println("test13--isArray==>"+ isArray);

        isArray = ArrayUtil.isArray(new String[]{"a","b","c"});
        System.out.println("test13--isArray==>"+ isArray);

        String string = "abc";
        isArray = ArrayUtil.isArray(string);
        System.out.println("test13--isArray==>"+ isArray);

        //结果：
        //test13--isArray==>true
        //test13--isArray==>true
        //test13--isArray==>true
        //test13--isArray==>false
    }

    /**
     * 14.转为字符串
     */
    private static void test14(){
        //ArrayUtil.toString 通常原始类型的数组输出为字符串时无法正常显示
        //于是封装此方法可以完美兼容原始类型数组和包装类型数组的转为字符串操作
        int[] intArray = {1,2,3};
        String string = ArrayUtil.toString(intArray);
        System.out.println("test14--string==>"+ string);

        //ArrayUtil.join 方法使用间隔符将一个数组转为字符串，比如 [1,2,3,4]
        //这个数组转为字符串，间隔符使用"-" 的话，结果为 1-2-3-4
        //join 方法同样支持泛型数组和原始类型数组
        int[] intArray1 = {4,5,6};
        String join = ArrayUtil.join(intArray1, "-");
        System.out.println("test14--join==>"+ join);

        //结果：
        //test14--string==>[1, 2, 3]
        //test14--join==>4-5-6

    }

    /**
     * 15.toArray
     */
    private static void test15(){
        //`ArrayUtil.toArray` 方法针对 ByteBuffer 转数组提供便利
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.flip();
        byte[] bytes = ArrayUtil.toArray(byteBuffer);
        System.out.println("test15--bytes==>"+ Arrays.toString(bytes));

        //结果：
        //test15--bytes==>[1, 2, 3]
    }
}
