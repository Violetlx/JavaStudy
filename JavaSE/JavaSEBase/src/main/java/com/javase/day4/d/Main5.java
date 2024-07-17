package com.javase.day4.d;

/**
 * 局部内部类
 * @author lixuan
 * @Date 2024/6/13 12:23
 */
public class Main5 {
    //局部内部类就像局部变量一样，可以在方法中定义

    private final String name;
    public Main5(String name) {
        this.name = name;
    }

    public void hello() {

        //既然是在方法中声明的类，那作用范围也就只能在方法中了

        class Inner { //局部内部类跟局部变量一样，先声明后使用
            public void show() { //直接在方法中创建局部内部类
                System.out.println("我是局部内部类 " + name);
            }

        }

        System.out.println("1111111111");

        //局部内部类直接使用类名就行
        Inner inner = new Inner();
        inner.show();
    }
}
