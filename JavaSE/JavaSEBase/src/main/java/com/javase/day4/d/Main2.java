package com.javase.day4.d;

/**
 * 成员内部类使用
 * @author lixuan
 * @Date 2024/6/13 10:18
 */
public class Main2 {
    public static void main(String[] args) {
        //我们首先需要创建对象
        Main1 Main1 = new Main1("张三");
        //成员内部类的类型名称就是 外层.内部类名称
        Main1.Inner inner = Main1.new Inner();

        //虽然看着很奇怪，但确实是这样使用的，我们同样可以使用成员变量内部类中的方法
        inner.show();

        //注意，成员内部类也是可以使用访问控制权限的，如果我们将其权限改为 private ，那么就像我们把成员变量访问权限变成私有一样
        //外部是无法访问这个类的

        System.out.println("--------------------");
        
        //这里我们需要特别注意一下，在成员内部类中，是可以访问到外层的变量的

        //每个勒可以创建一个对象，每个对象中都有一个单独的类定义，可以通过这个成员内部类又创建出更多对象，套娃了属于是

        Main1 a = new Main1("小明");
        //依附于a创建的对象，那么就是a的
        Main1.Inner inner1 = a.new Inner();
        inner1.show();

        Main1 b = new Main1("小红");
        //依附于b创建的对象，那么就是b的
        Main1.Inner inner2 = b.new Inner();
        inner2.show();

        System.out.println("--------------------");

        //那么问题来了，外部能访问内部类的成员变量吗？

        inner2.test("小明");

        //所以说成员内部类其实在某些情况下使用起来比较麻烦，对于这种成员内部类，我们一般只会在类的内部自己使用


        
    }
}
