package com.javase.day3.a;

/**
 * 方法的进阶使用
 * @author lixuan
 * @Date 2024/5/29 10:15
 */
public class Main4 {

    public static void main(String[] args) {
        //方法之间是可以相互调用的
        say();

        System.out.println("---------------------");

        test2();
    }

    /**
     * 测试方法
     */
    static void test() {
        //实际上这里也是调用另一个方法
        System.out.println("我是test");
    }


    /**
     * 调用测试方法
     */
    static void say() {
        //在一个方法里面调用另一个方法
        test();
    }

    /**
     * 方法自己调用自己
     */
    static void test2() {
        //实际上这里也是调用另一个方法
        System.out.println("我是test2");
        //test2();
        //像这种自己调用自己的行为，我们称为递归调用，如果直接这样编写，会跟上面一样，出席那栈溢出错误

        System.out.println("---------------------");

        //但是我们给其合理地设置出口，就不会出席那这种问题，比如我们想要计算从1加到n的和
        int i = test3(10);
        System.out.println(i);
    }

    /**
     * 计算从1到n的和
     * @param n
     * @return
     */
    static int test3(int n) {
        if (n == 0) {
            return 0;
        }
        return n + test3(n - 1);
    }
}
