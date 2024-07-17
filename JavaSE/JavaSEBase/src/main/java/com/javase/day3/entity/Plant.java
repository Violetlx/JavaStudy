package com.javase.day3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 植物类(类的封装)
 * @author lixuan
 * @Date 2024/5/29 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
    String name;
    int age;
    String sex;

    /**
     * 重写方法可以添加 @Override 注解，有关注解我们会在最后一章进行介绍，这个注解默认情况下可以省略
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {   //重写方法要求与父类的定义完全一致
        //如果传入的对象为null，那肯定不相等
        if(obj == null) return false;
        //只有是当前类型的对象，才能进行比较，要是都不是这个类型还比什么
        if(obj instanceof Plant) {
            //先转换为当前类型，接着我们对三个属性挨个进行比较
            Plant plant = (Plant) obj;
            //字符串内容的比较，不能使用==，必须使用equals方法
            return this.name.equals(plant.name) &&
                    this.age == plant.age &&       //基本类型的比较跟之前一样，直接==
                    this.sex.equals(plant.sex);
        }
        return false;
    }


    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {    //使用IDEA可以快速生成
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
