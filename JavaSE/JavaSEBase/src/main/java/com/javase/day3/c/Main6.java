package com.javase.day3.c;

import com.javase.day3.entity.Researcher;
import com.javase.day3.entity.Study;

/**
 * 接口
 * @author lixuan
 * @Date 2024/5/30 11:37
 */
public class Main6 {
    public static void main(String[] args) {
        //接口的目标就是将类所具有的某些行为抽象出来

        //关键字 interface  创建接口

        //接口中只能定义访问权限为public的抽象方法，其中public和abstract关键字可以省略

        //关键字 implements  实现接口

        Researcher researcher = new Researcher("李四", 20, "男");
        researcher.study();

        System.out.println("=======================");

        //接口不同于继承，接口可以同时实现多个

        //所以有些人说接口其实是Java中的多继承，但是个人认为这个说法是错的，实际上接口更像是一个类的功能列表，作为附加功能存在
        //一个类可以附加很多个功能，接口的使用和继承的概念有一定地出入，顶多说是多继承的一种替代方案

        //接口和抽象类一样，不能直接创建对象，但是我们也可以将实现类的对象以接口的形式去使用
        //当作接口实用时，只有接口中定义的方法和Object类的方法才能使用，不能使用类本身的方法和父类的方法

        //接口同样支持向下转型

        //从Java8开始，接口中可以存在方法的默认实现
        researcher.study();
        System.out.println("=======================");

        //如果方法在接口中存在默认是实现，那么实现类中不强制要求实现

        //接口不同于类，接口中不允许成员变量和成员方法，但是可以存在静态变量和静态方法，在接口中定义的变量只能是 public static final 所修饰
        //接口中定义的静态方法也只能是 public 的

        //跟普通的类一样，我们也可以直接通过 接口名.方法 的方式来调用静态内容
        System.out.println(Study.a);
        Study.test1();

        /**
         * 克隆操作可以完全复制一个对象的属性，但是像这样的拷贝操作其实也分为浅拷贝和深拷贝。
         * 浅拷贝：对于类中基本数据类型，会直接复制值给拷贝对象；对于引用类型，只会复制对象的地址，而实际上只想的还是原来的那个对象
         * 深拷贝：无论是基本类型还是引用类型，深拷贝会将引用类型的所有内容，全部拷贝为一个新对象，包括对象内部的成员变量，也会进行拷贝
         */

        //Java为我们提供的clone方法只会进行浅拷贝

        //接口可以继承自其他接口，并且接口没有继承数量限制，接口支持多继承
        /**
         * public interface A extends B {
         *
         * }
         *
         * public interface A extends B, C, D {
         *
         * }
         */




    }
}
