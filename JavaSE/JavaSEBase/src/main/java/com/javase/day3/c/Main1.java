package com.javase.day3.c;

import com.javase.day3.entity.Dog;
import com.javase.day3.entity.Plant;
import com.javase.day3.entity.Test;

/**
 * 类的封装
 * @author lixuan
 * @Date 2024/5/29 14:18
 */
public class Main1 {
    public static void main(String[] args) {
        /*
         * 封装的目的是为了保证变量的安全性，使用者不必在意具体实现细节，而只是通过外部姐口即可访问类的成员
         * 如果不进行封装，类中的实例变量可以直接查看和修改，可能给整个代码带来不好的影响，因此在编写类时
         * 一般将成员变量私有化，外部类需要使用Getter和Setter方法来查看和设置变量
         */
        Plant plant = new Plant(); 
        plant.setName("人参");
        plant.setAge(18);
        plant.setSex("雄");
        System.out.println(plant.getName());
        System.out.println(plant.getAge());
        System.out.println(plant.getSex());

        System.out.println("=======================================================");

        Dog dog = Dog.getInstance();
        dog.setName("旺财");
        dog.setAge(18);
        dog.setSex("雄");
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getSex());

        System.out.println("=======================================================");
        Dog dog2 = Dog.getInstance();
        dog2.setName("旺财");
        dog2.setAge(18);
        dog2.setSex("雄");
        System.out.println(dog==dog2);

        System.out.println("=======================================================");

        Test test1 = Test.getInstance();
        Test test2 = Test.getInstance();
        System.out.println(test1 == test2);


        //封装思想其实就是把实现的细节给隐藏了，外部只需要知道这个方法是什么作用，而无需关心实现，要用什么由类自己来做
        //不需要外面操作类内部的东西去完成，封装就是通过访问权限控制来实现的。
    }
}
