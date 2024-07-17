package com.javase.day2.c;

/**
 * 括号运算符
 * @author lixuan
 * @Date 2024/4/29 15:46
 */
public class Main4 {
    public static void main(String[] args) {
        //提升某些运算的优先级

        int a = 10;
        int b = (a = 8) * (-a + 10);
    /*
        1. 括号的优先级是最高的，我们需要先计算括号中的内容，如果存在多个括号，就从左往右计算
        2. 首先是 a = 8，计算完成之后a变成8，并且运算结果也为8
        3. 然后是后面的加法，-a就是-8，加上10就是2
        4. 最后才是乘法，左边此时是8，右边是2，最后结果为16
     */
        System.out.println(b);

        System.out.println("----------------");

        //括号除了可以提升优先级之外，还可以用作强制类型转换
        int c = 10;
        double d = (double) c;
        short e = (short) c;
        System.out.println(d);
        System.out.println(e);

        //已经超出byte的范围了
        int a1 = 128;
        //此时强制类型转换为byte类型，那么只会保留byte能够表示的bit位
        byte b1 = (byte) a1;
        System.out.println(b1);

        System.out.println("----------------");

        //有了强制类型转换，我们就可以很轻松地让两个整数计算出小数的结果了：
        int f = 8,g=5;
        double h =  f / (double)g;
        //强制类型转换的优先级跟正负号一样
        //计算时，只需要将其中一者转换为double类型，此时按照隐式类型转换规则，全都会变成double参与运算，所以结果也就是小数了
        System.out.println(h);

    }
}
