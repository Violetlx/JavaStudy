package com.javase.day2.c;

/**
 * 算术运算符
 * @author lixuan
 */
public class Main3 {
    public static void main(String[] args) {
        //取模运算
        int a = 10;
        int b = 3;
        System.out.println(a%b);

        System.out.println("---------------------");

        //变量也可以参与到算术运算中
        int c = a - b;
        System.out.println(c);

        System.out.println("---------------------");

        //不同类型也可以进行运算
        int d = 10;
        double e = 3.14;
        System.out.println(d+e);
        System.out.println(d-e);

        System.out.println("---------------------");
        /*
         * 不同类型的整数一起运算，小类型需要转换为大类型，short、byte、char一律转换为int再进行计算（无论算式中有无int，都需要转换）
         * 结果也是int；如果算式中出现了long类型，那么全部都需要转换到long类型再进行计算，结果也是long，反正就是依大的来
         */

        //因为运算时会发生隐式类型转换，所以说这里b自动转换为了int类型进行计算，所以说最后得到结果也一定是转换后的类型

        //相反数
        int f = -b;
        System.out.println(f);
        System.out.println(-f);

        System.out.println("---------------------");

        //乘法、除法
        System.out.println(a*b);

        //上面是两个int类型的值进行的除法运算，正常情况下8除以5应该得到1.6，但是由于结果也是整数，所以说最后小数部分被丢弃 3
        System.out.println(a/b);

        System.out.println("---------------------");

        int a1 = 10;
        int b1 = a1 = 8 * -a1 + 10;
    /*
        1. 正负号优先级最高，所有首先计算的是-a，得到-10
        2. 其次是乘除号优先级更高，所以说这里计算 8 * -10，得到 -80
        3. 然后是加减法，-80 + 10 = -70
        4. 最后是赋值运算，因为等号运算符从右往左结合，先算a = -70的结果就是 -70
        5. 最后b就是 -70
     */
        System.out.println(b1);
    }
}
