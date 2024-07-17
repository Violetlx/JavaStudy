package com.javase.day4.e;

/**
 * 自定义异常
 * @author lixuan
 * @Date 2024/6/14 11:41
 */
public class Main2 {
    //异常其实就两个大类，一个是编译时异常，一个是运行时异常

    //编译时异常只需要继承Exception就行了，编译时异常的子类有很多，仅仅SE中就有700多个

    //异常多种多样，不同的异常对应着不同的情况，比如在类型转换时出错那么就是类型转换异常，
    //如果是使用一个值为null的变量调用方法，那么就会出现空指针异常。

    public class TestException1 extends Exception{
        //编译时异常只需继承Exception即可

        public TestException1(String message){
            //这里我们选择使用父类的带参构造，这个参数就是异常的原因
            super(message);
        }
    }


    //运行时异常只需要继承RuntimeException即可

    public class TestException2 extends RuntimeException{
        public TestException2(String message){
            super(message);
        }
    }

    //RuntimeException继承自Exception，Exception继承自Throwable
    //当然还有一种类型是Error，它是所有错误的父类，同样是继承自Throwable

}
