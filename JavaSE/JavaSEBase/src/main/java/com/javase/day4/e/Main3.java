package com.javase.day4.e;

import java.io.FileNotFoundException;

/**
 * 抛出异常
 * @author lixuan
 * @Date 2024/6/14 14:28
 */
public class Main3 {
    //当别人调用我们的方法时，如果传入了错误的参数导致程序无法正常运行，这是我们就可以手动抛出来一个异常来终止程序继续运行下去，同时告知
    //上一级方法执行出了问题

    public static void main(String[] args) throws Exception {
        System.out.println("准备开测！！");
        //int result = test(10, 0);
        System.out.println("程序能否继续执行？？？");

        //当出现异常，程序会终止并且打印栈追踪信息，实际上方法之间的调用是有层级关系的，而当发生异常时，方法调用的每一层都会在栈追踪
        //信息中打印出来，比如这里的两个at，实际上就是告诉我们程序运行到哪个位置时出现的异常
        /*
         * Exception in thread "main" java.lang.RuntimeException: 被除数不能为0
         * 	at com.javase.day4.e.Main3.test(Main3.java:22)
         * 	at com.javase.day4.e.Main3.main(Main3.java:14)
         */

        //注意，如果我们在方法中抛出了一个非运行时异常，那么必须告知函数的调用方法我们会抛出某个异常，函数调用放必须要对抛出这个异常进行处理才可以

        //test();

        //最后再提一下，我们在重写方法时，如果父类中的方法表明了会抛出某个异常，只要重写的内容中不会抛出对应的异常我们可以直接省去：

        /*
         * @Override
         * protected Object clone() {
         *     return new Object();
         * }
         */

    }

    /**
     * 异常地抛出同样需要创建一个异常对象，我们抛出异常实际上就是将这个异常对象抛出，异常对象携带了我们抛出异常时的一些信息
     * 比如是因为什么原因导致的异常，在RuntimeException的构造方法中我们可以写入原因。
     */
    public static int test(int a, int b) {
        if(b == 0) {
            //使用throw关键字来抛出异常
            throw new RuntimeException("被除数不能为0");
        }
        return a / b;
    }

    private static void test() throws Exception {    //使用throws关键字告知调用方此方法会抛出哪些异常，请调用方处理好
        throw new Exception("我是编译时异常！");
    }

    /**
     * //注意，如果不同的分支条件会出现不同的异常，那么所有在方法中可能会抛出的异常都需要注明：
     * @param a
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private static void test(int a) throws FileNotFoundException, ClassNotFoundException {  //多个异常使用逗号隔开
        if(a == 1) {
            throw new FileNotFoundException();
        } else {
            throw new ClassNotFoundException();
        }
    }
}
