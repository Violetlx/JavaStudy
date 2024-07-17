package com.javase.day4.d;

/**
 * 静态内部类
 * @author lixuan
 * @Date 2024/6/13 10:37
 */
public class Main3 {
    //静态内部类就像静态方法和静态变量，是属于类的，我们可以直接创建使用

    private final String name;

    public Main3(String name) {
        this.name = name;
    }

    public static class Inner{
        public void show() {
            System.out.println("我是静态内部类");

            //静态内部类不能访问外部类的非静态成员变量
            //System.out.println("我是静态内部类"+name);
        }

        String name;
        public void test(){ //只不过受影响的只是外部内容的使用，内部倒是不受影响，还是跟普通类一样
            System.out.println("我是静态内部类："+name);
        }

        //其实也很容易想通，因为静态内部类是属于外部类的，不依附于任何对象，那么我要是直接访问外部类的非静态属性，那到底
        //访问哪个对象呢？这样肯定是说不通的
    }
}
