package com.javase.day4.e;

/**
 * 异常的类型
 * @author lixuan
 * @Date 2024/6/14 9:27
 */
public class Main1 {
    /**
     * 在理想的情况下，我们的程序会按照我们的思路，按理说是不会出现问题的，但是，代码实际编写后并不一定是完美的，可能会有我们没有考虑的情况，
     * 如果这些情况能够正常得到一个错误的结果还好，但是如果直接导致程序运行出现问题了呢？
     */

    public static void main(String[] args) {
        try {
            // 当b为0的时候，还能正常运行吗？
            test( 1,  0);
            // by zero 出现了异常
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        //异常的类型
        /**
         * 我们之前其实已经接触过一些异常了，比如数组越界异常、空指针异常、算术异常等，它们其实都是异常类型。我们的每一个异常也是一个类
         * 它们都继承自 Exception 类！异常类型本质依然是类的对象，但是异常类支持在程序运行出现问题时抛出(也就是控制台红色的报错)也可以
         * 提前声明，告知使用者需要处理可能会出现的异常
         */

        /**
         * 异常的第一种类型时运行时异常，如上述例子，在编译阶段无法感知代码是否会出现问题，只有在运行的时候才知道会不会出错(正常情况是不会出错的)
         * 这样的异常称为运行时异常，异常也是由类定义的。所有的运行时异常都继承自RuntimeException类。
         */
        try {
            // 创建一个null对象
            Object object = null;

            // 尝试调用toString()方法，这会导致空指针异常
            object.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        //又比如下面这种情况
        try {
            // 尝试将一个Object对象强制转换为Main1对象
            Object object = new Object();
            // 抛出ClassCastException  类编译异常
            Main1 main1 = (Main1) object;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        //异常的另一种类型是编译时异常，编译时异常明确指出可能会出现的异常，在编译阶段就需要进行处理(捕获异常)必须要考虑到出现异常
        //的情况，如果不及逆行处理将无法通过编译！默认继承自Exception类的异常都是编译时异常。

        //protected native Object clone() throws CloneNotSupportedException;
        //比如Object类中定义的clone方法，就明确指出了在运行的时候会出现的异常

        //还有一种类型是错误，错误比一场更严重，异常就是不同寻常，但不一定会导致致命的问题，而错误是致命问题，一般出现错误可能JVM就无法继续
        //正常运行了，比如 OutOfMemoryError 就是内存溢出错误(内存占用已经超出限制，无法继续申请内存了)
        //test();
        //这种情况就是错误了，已经严重影响到整个程序都无法正常运行了。又比如：
        //这里申请一个超级大数组
        Object[] objects = new Object[Integer.MAX_VALUE];

        //实际上我们电脑的内存是有限的，不可能无限制地使用内存来存放变量。所以说，如果内存不够用了，会直接报错
        //Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        //此时没有更多的可用内存供我们的程序使用，那么程序也就没办法继续运行下去了，这同样是一个很严重的错误。


    }

    private static int test(int a, int b){
        //没有任何的判断而是直接做计算
        return a/b;
    }

    /**
     * 内存溢出测试
     */
    private static void test(){
        test();
    }
}
