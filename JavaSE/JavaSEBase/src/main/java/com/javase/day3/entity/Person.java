package com.javase.day3.entity;

import lombok.Data;

/**
 * 人类(类的定义)
 * @author lixuan
 * @Date 2024/5/28 16:03
 */
@Data
public class Person {
    /**
     * 这里定义的人类具有三个属性：姓名，年龄，性别
     */
    String name;
    int age;
    String sex;
    public static String info;

    //静态代码块
    static {
        info = "测试";
    }

    public Person(String name, int age, String sex, String name1) {
        this.name = name;
        this.age = age;
        this.sex = sex;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    {
        //代码块中的内容会在对象创建时仅执行一次
        //只不过一般情况下使用代码的频率比较低，标准情况下还是通过构造方法进行对象初始化工作
        System.out.println("我是代码块");
    }

    /**
     * 无参构造
     */
    public Person() {
        System.out.println("无参构造");
    }

    /**
     * 有参构造
     * 注意，在我们自己定义一个构造方法之后，会覆盖掉默认的那一个无参构造方法，除非我们手动重载一个无参构造
     * 否则要创建这个类的对象，必须调用我们自己定义的构造方法
     */
    public Person(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    /**
     * 自我介绍只需要完成就行，没有返回值，所以说使用void
     */
    public void hello(){
        //完成自我介绍需要执行的所有代码就在这个花括号中编写
        //这里编写代码跟我们之前在main中是一样的（实际上main就是一个函数）
        //自我介绍需要用到当前对象的名字和年龄，我们直接使用成员变量即可，变量的值就是当前对象的存放值
        System.out.println("我叫 "+name+" 今年 "+age+" 岁了！");
    }

    /**
     * 求和
     */
    public int getSum(int a,int b) {
        //return后面需要紧跟返回的结果，这样就可以将计算结果丢出去了
        //带返回值的方法，是一定要有一个返回结果的！否则无法通过编译
        return a+b;
    }

    /**
     * 参数传递
     */
    public void swap(int a,int b) { //目的是交换a和b的值
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void modify(Person person) {
        person.setName("lbwnb");
    }

}
