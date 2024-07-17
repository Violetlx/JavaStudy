package com.javase.day4.c;

/**
 * String类
 * @author lixuan
 * @Date 2024/6/12 15:48
 */
public class Main1 {
    /**
     * 字符串是一个比较特殊的类，它用于保存字符串。我们知道，基本类型char可以保存一个2字节的Unicode字符，而String类可以保存一个Unicode字符序列。
     * 是一系列字符的序列（在C中就是一个字符数组）Java中没有字符串这种基本类型，因此只能用类来定义。
     * 注意：字符串中的字符一旦去欸的那个，无法修改，只能重新创建。
     */
    public static void main(String[] args) {
        //String类本身也是一个类，只不过它比较特殊，每个用双引号括起来的字符串都是String类型的一个实例对象
        String str = "Hello World!";
        System.out.println("str ===> "+str);

        System.out.println("----------------------------");

        //当然，我们也可以使用new关键字
        String str1 = new String("Hello World!");
        System.out.println("str1 ===> "+str1);

        System.out.println("----------------------------");

        //注意：如果是直接使用双引号创建的字符串，如果内容相同，为了优化效率，那么始终都是同一个对象
        String str2 = "Hello World!";
        String str3 = "Hello World!";
        System.out.println(str2==str3);

        System.out.println("----------------------------");

        //但是如果我们使用构造方法主动创建两个新对象，那么就是不同的对象了
        String str4 = new String("Hello World!");
        String str5 = new String("Hello World!");
        System.out.println(str4==str5);
        //判断内容是否相同
        System.out.println(str4.equals(str5));

        System.out.println("----------------------------");

        //既然String也是一个类，那么肯定具有一些方法

        //length   length方法可以求字符串长度，这个长度是字符的数量
        System.out.println(str.length());

        //虽然看起来挺奇怪的，但是确实支持这种写法
        System.out.println("Hello World".length());

        System.out.println("----------------------------");

        //substring 字符串的裁剪
        String str6 = "Hello World!";
        //裁剪字符串，并返回一个新的字串对象
        String s = str6.substring(0, 5);
        System.out.println(s);

        //split 分割
        String str7 = "Hello World!";
        String[] split = str7.split("");
        for (String s1 : split) {
            System.out.print(s1+" ");
        }

        System.out.println();
        System.out.println("----------------------------");

        //字符串和数组之间是可以快速转换的
        String str8 = "Hello World!";
        char[] chars = str8.toCharArray();
        System.out.println(chars);

        char[] chars1 = new char[]{'奥', '利', '给'};
        String string = new String(chars1);
        System.out.println(string);

        System.out.println("----------------------------");

        //contains 包含
        String str9 = "Hello World!";
        boolean b = str9.contains("World");
        System.out.println(b);
    }
}
