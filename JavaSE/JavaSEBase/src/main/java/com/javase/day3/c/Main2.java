package com.javase.day3.c;

import com.javase.day3.entity.Person;
import com.javase.day3.entity.Student;

/**
 * 类的继承
 * @author lixuan
 * @Date 2024/5/29 14:37
 */
public class Main2 {

    public static void main(String[] args) {
        /*
         * 在定义不同类的时候存在一些相同的属性，为了方便使用可以将这些共同属性抽象成一个父类，在定义其他子类的时候可以继承自该父类
         * 减少代码的重复定义，子类可以使用父类中非私有的成员。
         *
         * 比如我们一开始使用的人类，那么实际上人类根据职业划分，所掌握的技能也会有所不同，比如画家会画画，歌手会唱歌，Rapper会rap，
         * 运动员会篮球，我们可以将人类这个大类根据职业进行进一步的细分出来
         *
         * 实际上这些划分出来的类本质上还是人类，也就是说人类具有的属性，这些划分出来的类同样具有，但是这些划分出来的类同时也会拥有他们自己
         * 独特的技能。在Java中，我们可以创建一个类的子类来是心啊上面的这种效果。
         */

        //想要继承一个类，我们只需要使用extends关键字即可

        //类可以不断向下继承，但是同时只能继承一个类，同时，标记为final的类不能被继承

        //当一个类继承了另一个类时，属性会被继承，可以直接访问父类中定义的属性，除非父类中将属性的访问权限修改为private
        //那么子类将无法访问(但是依然继承了这个属性，只是由于权限而无法访问，可以使用反射来证明)

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        student.study(); //子类不仅有自己独特的技能
        student.hello(); //还继承了父类的全部技能

        //同样的，在父类中定义的方法同样会被子类继承

        System.out.println("===============================================");

        Person person=new Student();
        if (person instanceof Student) {
            System.out.println("person是Student类型");
        }else if (person instanceof Person) {
            System.out.println("person是Person类型");
        }

        //子类可以定义和父类同名的属性

        //没有super.super的用法，也就是说如果存在多级继承的话，那么最多只能通过这种方法访问到父类的属性，包括继承下来的属性
    }
}
