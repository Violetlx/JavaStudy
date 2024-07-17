package com.javase.day2.b;

/**
 * 浮点型
 * @author lixuan
 */
public class Main2 {
    public static void main(String[] args) {
        //单精度浮点型 （32bit，4字节） ±3.40282347×10^38
        float f = 3.14f;
        System.out.println(f);

        //双精度浮点型 （64bit，8字节） ±1.7976931348623157×10^308
        double d = 3.14;
        System.out.println(d);

        double d2 = f;
        System.out.println(d2);

        //隐式类型转换为double值
        float f1 = 9.9F;
        double a1 = f1;
        System.out.println(a1);

        /*
         * 此时我们发现，long类型的值居然可以直接丢给float类型隐式类型转换，很明显float只有32个bit位，而long有足足64个，这是什么情况？
         * 怎么大的还可以隐式转换为小的？这是因为虽然float空间没有那么大，但是由于是浮点类型，指数可以变化，最大的数值表示范围实际上是大于
         * long类型的，虽然会丢失精度，但是确实可以表示这么大的数。
         */

        //隐式类型转换规则：byte→short(char)→int→long→float→double
    }
}
