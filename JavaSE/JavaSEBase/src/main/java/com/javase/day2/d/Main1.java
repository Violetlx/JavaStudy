package com.javase.day2.d;

/**
 * 代码块与作用域
 * @author lixuan
 * @Date 2024/4/30 10:18
 */
public class Main1 {
    public static void main(String[] args) { //现目前这个阶段，我们还是在主方法中编写代码，不要跑去外面写
        System.out.println("外层");
        {   //自由创建代码块
            int a = 10;
            System.out.println(a);
        }
        //变量的使用范围，仅限于其定义时所处的代码块，一旦超出对应的代码块区域，那么就相当于没有这个变量了。
        //System.out.println(a);      //不成立

        //此时变量在最外层定义
        int a = 10;
        {
            //处于其作用域内部的代码块可以使用
            System.out.println(a);
        }
        //这里肯定也可以使用
        System.out.println(a);
    }
}
