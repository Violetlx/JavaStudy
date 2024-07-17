package com.javase.day4.d;

/**
 * 成员内部类
 * @author lixuan
 * @Date 2024/6/12 17:37
 */
public class Main1 {
    //内部类顾名思义就是创建在内部的类

    private final String name;
    public Main1(String name) {
        this.name = name;
    }

    //这里我们需要特别注意一下，在成员内部类中，是可以访问到外层的变量的

    public class Inner{ //内部类也是类，所以说里面也可以有成员变量、方法等，甚至还可以继续套娃一个成员内部类

        String name;
        public void show(){
            //依然是就近原则，最近的是参数，那就是参数了
            System.out.println("我是成员内部类: "+name);
            //成员内部类可以访问到外部的成员变量
            //因为成员内部类本身就是某个对象所有的，每个对象都有这样的一个类定义，这里的name是其所依附对象的

            //在内部类中使用this关键字，只能表示内部类对象
            //System.out.println("成员内部类的name = "+this.name);
            System.out.println("成员内部类的name = "+Main1.this.name);
            //如果需要指定为外部的对象，那么需要在前面添加外部类型名称
        }

        //包括对方法的调用和super关键字的使用，也是一样的：
        public void test(String name){
            System.out.println("我是成员内部类: "+name);
            this.toString();		//内部类自己的toString方法
            super.toString();    //内部类父类的toString方法
            Main1.this.toString();   //外部类的toSorting方法
            Main1.super.toString();  //外部类父类的toString方法
        }

    }
}
