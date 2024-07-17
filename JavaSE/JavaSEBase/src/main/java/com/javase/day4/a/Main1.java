package com.javase.day4.a;

/**
 * 基本类型包装类
 * @author lixuan
 * @Date 2024/6/12 11:16
 */
public class Main1 {
    public static void main(String[] args) {
        /**
         * Java并不是单纯面向对象的语言。虽然Java语言是一个面向对象的语言，但是Java中的基本数据类型却不是面向对象的。Java中的基本类型，如果
         * 想通过对象的形式去使用它们，Java提供了基本类型包装类，使得Java能够更好的体现面向对象的思想，同时也使得基本类型能够支持对象操作。
         */

        /**
         * 其中能够表示数字的基本类型包装类，继承自Number类，对应关系如下表：
         * <p>
         * byte -> Byte
         * boolean -> Boolean
         * short -> Short
         * char -> Character
         * int -> Integer
         * long -> Long
         * float -> Float
         * double -> Double
         */

        @SuppressWarnings("all")
        Integer i = new Integer(10);//将10包装为一个Integer类型的变量
        System.out.println(i);

        System.out.println("-----------------");

        //包装类实际上就是将我们的基本数据类型，封装成一个类(运用封装的思想)，我们可以看看Integer中是怎么写的

        //包装类支持自动装箱和自动拆箱

        //将int类型的值作为包装类型使用
        Integer i1 = 10;
        System.out.println(i1);
        //上面的写法和这里是等价的
        Integer i2 = Integer.valueOf(10);
        System.out.println(i2);

        System.out.println("-----------------");

        //这里本质上就是被自动包装成了一个Integer类型的对象，只是为了语法上的简单，就支持像这样编写，既能装箱也能拆箱

        //自动拆箱
        //通过此方法变成基本类型int值
        Integer i3 = 10;
        int a = i3;
        System.out.println(a);
        Integer i4 = Integer.valueOf(10);
        int b = i4.intValue();
        System.out.println(b);

        System.out.println("-----------------");

        //直接自动拆箱成基本类型参与到计算中
        Integer i5 = 10,i6 = 20;
        int c = i5 + i6;
        System.out.println(c);

        System.out.println("-----------------");

        //因为包装类是一个类，不是基本类型，所以说是两个不同的对象，那么是不想等的。
        @SuppressWarnings("all")
        Integer i7 = new Integer(10);
        @SuppressWarnings("all")
        Integer i8 = new Integer(10);
        //虽然a和b的值相同，但是并不是同一个对象，所以说==判断为假
        System.out.println(i7==i8);

        System.out.println("-----------------");

        //那么自动装箱的呢？
        Integer i9 = 10;
        Integer i10 = 10;
        System.out.println(i9==i10);

        //我们发现自动装箱转换的Integer对象，如果值相同，得到的会是同一个对象，这是因为
        /**
         * public static Integer valueOf(int i) {
         *     if (i >= IntegerCache.low && i <= IntegerCache.high)   //这里会有一个IntegerCache，如果在范围内，那么会直接返回已经提前创建好的对象
         *         return IntegerCache.cache[i + (-IntegerCache.low)];
         *     return new Integer(i);
         * }
         * <p>
         * IntegerCache会默认缓存-128~127之间的所有值，将这些值提前做成包装类放在数组中存放，虽然我们目前还没有学习数组，但是各位小伙伴只需要知道，我们如果直接让
         * -128~127之间的值自动装箱为Integer类型的对象，那么始终都会得到同一个对象，这是为了提升效率，因为小的数使用频率非常高，有些时候并不需要创建那么多对象，
         * 创建对象越多，内存也会消耗更多。
         */
        //但是如果超出这个范围，那么就会创建一个新的对象，所以这里得到的两个对象是不同的。
        Integer i11 = 128;
        Integer i12 = 128;
        System.out.println(i11==i12);

        System.out.println("-----------------");

        //包装类中提供了哪些其他的方法，包装类支持字符串直接转换
        //直接将字符串的666，转换为数字666
        Integer i13 = Integer.valueOf("666");
        int i14 = Integer.parseInt("333");
        System.out.println(i13);
        System.out.println(i14);

        System.out.println("-----------------");

        //我们甚至可以对十六进制和八进制的字符串进行解析，得到对应的int值
        Integer i15 = Integer.decode("0xA6");
        System.out.println(i15);

        System.out.println("-----------------");

        //也可以将十进制的整数转换为其他进制的字符串

        String hexString = Integer.toHexString(166);
        System.out.println(hexString);
    }
}
