package com.javase.day3.a;

import com.javase.day3.entity.Person;

/**
 * 对象的使用
 * @author lixuan
 * @Date 2024/5/28 16:08
 */
public class Main2 {
    public static void main(String[] args) {
        //这里的a存放具体的某个值
        int a = 10;

        //创建一个变量指代我们刚刚创建好的对象，变量的类型就是对应的类名
        //这里的p存放的是对象的引用，而不是本体，我们可以通过对象的引用来间接操作对象
        Person person = new Person();

        System.out.println("Person:"+person);

        System.out.println("--------------------");

        Person p1 = new Person();
        Person p2 = p1;
        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);
        System.out.println("p1==p2:"+(p1==p2));

        //这里，我们将变量p2赋值为p1的值，那么实际上只是传递了对象的引用，而不是对象本身的复制，这跟我们前面的基本数据类型有些不同，p2和p1
        //都指向的是同一个对象

        //实际上我们之前所使用的String类型也是一个引用类型。

        System.out.println("--------------------");

        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setSex("男");
        System.out.println("p:"+p);

        System.out.println("name==="+p.getName());
        System.out.println("age==="+p.getAge());
        System.out.println("sex==="+p.getSex());

        System.out.println("--------------------");

        Person p3 = new Person();
        System.out.println("name = "+p3.getName());
        System.out.println("age = "+p3.getAge());
        System.out.println("sex = "+p3.getSex());

        //我们可以看到，如果直接创建对象，那么对象的属性都会存在初始值，如果是基本数据类型，你把么默认统一为0
        //如果是boolean的话，默认值为false  如果为引用类型，那么默认是null




    }
}
