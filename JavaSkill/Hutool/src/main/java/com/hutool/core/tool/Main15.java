package com.hutool.core.tool;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.util.Arrays;

import static cn.hutool.core.util.NumberUtil.round;
import static cn.hutool.core.util.NumberUtil.roundStr;

/**
 * 数字工具-NumberUtil
 * @author lixuan
 * @Date 2025/1/8 9:49
 */
public class Main15 {

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
    }

    /**
     * 1.加减乘除
     */
    public static void test1(){
        int a = 1, b = 2;
        // 加法
        double add = NumberUtil.add(a, b);
        System.out.println("test1--add==>"+add);
        // 减法
        double sub = NumberUtil.sub(a, b);
        System.out.println("test1--sub==>"+sub);
        // 乘法
        double mul = NumberUtil.mul(a, b);
        System.out.println("test1--mul==>"+mul);
        // 除法，并提供重载方法用于规定除不尽的情况下保留小数位数和舍弃方式
        double div = NumberUtil.div(a, b);
        System.out.println("test1--div==>"+div);
        double div2 = NumberUtil.div(1, 3, 6);
        System.out.println("test1--div2==>"+div2);

        //结果：
        //test1--add==>3.0
        //test1--sub==>-1.0
        //test1--mul==>2.0
        //test1--div==>0.5
        //test1--div2==>0.333333
    }

    /**
     * 2.保留小数
     */
    public static void test2(){
        //`NumberUtil.round` 方法主要封装 BigDecimal 中的方法来保留小数，
        //返回 BigDecimal，这个方法更加灵活，可以选择四舍五入或者全部舍弃等模式
        double te1=123456.123456;
        double te2=123456.128456;
        //结果:123456.1235
        BigDecimal round1 = round(te1, 4);
        Console.log("test2--round1==>"+round1);
        //结果:123456.1285
        BigDecimal round2 = round(te2, 4);
        Console.log("test2--round2==>"+round2);

        //NumberUtil.roundStr 方法主要封装 String.format 方法，舍弃方式采用四舍五入。
        double te3=123456.123456;
        double te4=123456.128456;
        //结果:123456.12
        String roundStr1 = roundStr(te3, 2);
        Console.log("test2--roundStr1==>"+roundStr1);
        //结果:123456.13
        String roundStr2 = roundStr(te4, 2);
        Console.log("test2--roundStr2==>"+roundStr2);

        //结果：
        //test2--round1==>123456.1235
        //test2--round2==>123456.1285
        //test2--roundStr1==>123456.12
        //test2--roundStr2==>123456.13
    }

    /**
     * 3.decimalFormat标准化
     */
    public static void test3(){
        //光速
        long c=299792458;
        //299,792,458
        String format = NumberUtil.decimalFormat(",###", c);
        Console.log("test3--format==>"+format);

        //0 -> 取一位整数
        //0.00 -> 取一位整数和两位小数
        //00.000 -> 取两位整数和三位小数
        //# -> 取所有整数部分
        //#.##% -> 以百分比方式计数，并取两位小数
        //#.#####E0 -> 显示为科学计数法，并取五位小数
        //,### -> 每三位以逗号进行分隔，例如：299,792,458
        //光速大小为每秒,###米 -> 将格式嵌入文本
        String format1 = NumberUtil.decimalFormat("0", c);
        Console.log("test3--format1==>"+format1);
        String format2 = NumberUtil.decimalFormat("0.00", c);
        Console.log("test3--format2==>"+format2);
        String format3 = NumberUtil.decimalFormat("00.000", c);
        Console.log("test3--format3==>"+format3);
        String format4 = NumberUtil.decimalFormat("#", c);
        Console.log("test3--format4==>"+format4);
        String format5 = NumberUtil.decimalFormat("#.##%", c);
        Console.log("test3--format5==>"+format5);
        String format6 = NumberUtil.decimalFormat("#.#####E0", c);
        Console.log("test3--format6==>"+format6);
        String format7 = NumberUtil.decimalFormat(",###", c);
        Console.log("test3--format7==>"+format7);
        String format8 = NumberUtil.decimalFormat("光速大小为每秒,###米", c);
        Console.log("test3--format8==>"+format8);

        //结果：
        //test3--format==>299,792,458
        //test3--format1==>299792458
        //test3--format2==>299792458.00
        //test3--format3==>299792458.000
        //test3--format4==>299792458
        //test3--format5==>29979245800%
        //test3--format6==>2.99792E8
        //test3--format7==>299,792,458
        //test3--format8==>光速大小为每秒299,792,458米
    }

    /**
     * 4.校检数字
     */
    public static void test4(){
        //判断是否为数字
        boolean isNumber = NumberUtil.isNumber("123");
        Console.log("test4--isNumber==>"+isNumber);
        //判断是否为整数
        boolean isInteger = NumberUtil.isInteger("123");
        Console.log("test4--isInteger==>"+isInteger);
        //判断是否为小数
        boolean isDouble = NumberUtil.isDouble("123.123");
        Console.log("test4--isDouble==>"+isDouble);
        //判断是否为质数
        boolean isPrimes = NumberUtil.isPrimes(123);
        Console.log("test4--isPrimes==>"+isPrimes);
        //判断是否为质数
        boolean isPrimes1 = NumberUtil.isPrimes(7);
        Console.log("test4--isPrimes1==>"+isPrimes1);

        //结果：
        //test4--isNumber==>true
        //test4--isInteger==>true
        //test4--isDouble==>true
        //test4--isPrimes==>false
        //test4--isPrimes1==>true
    }

    /**
     * 5.随机数
     */
    public static void test5(){
        //generateRandomNumber: 适用于小范围、少量随机数的生成，返回 int[]。
        //generateBySet: 适用于大范围、大量随机数的生成，返回 Integer[]。

        //NumberUtil.generateRandomNumber 生成不重复随机数
        //根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
        int[] ints = NumberUtil.generateRandomNumber(1, 10, 5);
        Console.log("test5--ints==>"+ Arrays.toString(ints));

        //NumberUtil.generateBySet 生成不重复随机数
        //根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
        Integer[] ints2 = NumberUtil.generateBySet(1, 10, 5);
        Console.log("test5--ints2==>"+ Arrays.toString(ints2));
    }

    /**
     * 6.整数列表
     */
    public static void test6(){
        //NumberUtil.range 生成整数列表
        //生成从 start 到 end 的整数列表，步长为 step 2
        int[] ints = NumberUtil.range(1, 10, 2);
        Console.log("test6--ints==>"+ Arrays.toString(ints));

        //NumberUtil.range 生成整数列表
        //生成从 start 到 end 的整数列表，步长为 step 3
        int[] ints1 = NumberUtil.range(1, 10, 3);
        Console.log("test6--ints1==>"+ Arrays.toString(ints1));

        //NumberUtil.range 生成整数列表
        //生成从 start 到 end 的整数列表，步长为 step 4
        int[] ints2 = NumberUtil.range(1, 10, 4);
        Console.log("test6--ints2==>"+ Arrays.toString(ints2));

        //结果：
        //test6--ints==>[1, 3, 5, 7, 9]
        //test6--ints1==>[1, 4, 7, 10]
        //test6--ints2==>[1, 5, 9]
    }

    /**
     * 7.其他
     */
    public static void test7(){
        //- `NumberUtil.factorial` 阶乘
        //- `NumberUtil.sqrt` 平方根
        //- `NumberUtil.divisor` 最大公约数
        //- `NumberUtil.multiple` 最小公倍数
        //- `NumberUtil.getBinaryStr` 获得数字对应的二进制字符串
        //- `NumberUtil.binaryToInt` 二进制转int
        //- `NumberUtil.binaryToLong` 二进制转long
        //- `NumberUtil.compare` 比较两个值的大小
        //- `NumberUtil.toStr` 数字转字符串，并自动去除尾小数点儿后多余的0

        long factorial = NumberUtil.factorial(5);
        Console.log("test7--factorial==>"+factorial);
        double sqrt = NumberUtil.sqrt(9);
        Console.log("test7--sqrt==>"+sqrt);
        long divisor = NumberUtil.divisor(10, 2);
        Console.log("test7--divisor==>"+divisor);
        long multiple = NumberUtil.multiple(10, 2);
        Console.log("test7--multiple==>"+multiple);
        String binaryStr = NumberUtil.getBinaryStr(10);
        Console.log("test7--binaryStr==>"+binaryStr);
        int binaryToInt = NumberUtil.binaryToInt("1010");
        Console.log("test7--binaryToInt==>"+binaryToInt);
        long binaryToLong = NumberUtil.binaryToLong("1010");
        Console.log("test7--binaryToLong==>"+binaryToLong);
        int compare = NumberUtil.compare(10, 20);
        Console.log("test7--compare==>"+compare);
        String toStr = NumberUtil.toStr(10);
        Console.log("test7--toStr==>"+toStr);

        //结果：
        //test7--factorial==>120
        //test7--sqrt==>3.0
        //test7--divisor==>2
        //test7--multiple==>10
        //test7--binaryStr==>1010
        //test7--binaryToInt==>10
        //test7--binaryToLong==>10
        //test7--compare==>-1
        //test7--toStr==>10
    }

}
