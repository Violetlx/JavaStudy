package com.javase.day4.e;

import java.io.IOException;

/**
 * 异常处理
 * @author lixuan
 * @Date 2024/6/14 15:04
 */
public class Main4 {
    public static void main(String[] args) throws IOException {
        //利用try-catch语句进行异常捕获，即时出现异常，程序仍然可以正常运行

        try {    //使用try-catch语句进行异常捕获
            Object object = null;
            object.toString();
        } catch (NullPointerException e){   //因为异常本身也是一个对象，catch中实际上就是用一个局部变量去接收异常
            //打印栈追踪信息
            e.printStackTrace();
            //获取异常的错误信息
            System.out.println("异常错误信息："+e.getMessage());
        }
        //将代码编写到try语句块中，只要是在这个范围内发生的异常，都可以被捕获，使用catch关键字对指定的异常进行捕获
        //这里我们捕获的是NullPointerException空指针异常
        //注意：catch中捕获的类型只能是Throwable的子类，也就是说要么是异常、要么是错误，不能是其他任何类型
        System.out.println("程序继续正常运行！");

        try {
            int[] arr = new int[1];
            //这里发生的是数组越界异常，它是运行时异常的子类
            arr[1] = 100;
        } catch (RuntimeException e){  //使用运行时异常同样可以捕获到
            e.printStackTrace();
            System.out.println("捕获到异常");
        }

        //当然，如果我们确实不想在当前这个方法中进行处理，那么我们可以继续踢皮球，抛给上一级，抛出异常会终止程序
        //test(10);

        /*
         * try {
         *   //....
         * } catch (NullPointerException e) {
         *
         * } catch (IndexOutOfBoundsException e){
         *
         * } catch (RuntimeException e){
         *
         * }
         *
         * 但是要注意顺序
         *
         * try {
         *   //....
         * } catch (RuntimeException e){  //父类型在前，会将子类的也捕获
         *
         * } catch (NullPointerException e) {   //永远都不会被捕获
         *
         * } catch (IndexOutOfBoundsException e){   //永远都不会被捕获
         *
         * }
         *
         * 简写
         *
         * try {
         *   //....
         * } catch (NullPointerException | IndexOutOfBoundsException e) {  //用|隔开每种类型即可
         *
         * }
         *
         * 如果简写了，那么发生这些异常的时候，都会采用统一的方式进行处理了
         *
         */

        //finally 语句块
        //无论是否出现异常，都会执行
        try {
            int[] arr = new int[1];
            arr[1] = 100;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("finally语句块中的代码一定会执行");
        }

        //try语句块至少要配合catch和finally中的一个
        try {
            int a = 10;
            a /= 0;
        } finally {  //不捕获异常，程序会终止，但在最后依然会执行下面的内容
            System.out.println("lbwnb");
        }
    }

    private static void test(int a) throws IOException {
        throw new IOException();
    }
}
