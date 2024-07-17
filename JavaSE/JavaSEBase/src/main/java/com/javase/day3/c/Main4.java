package com.javase.day3.c;

import com.javase.day3.entity.Plant;

/**
 * 方法的重写
 * @author lixuan
 * @Date 2024/5/29 15:16
 */
public class Main4 {
    public static void main(String[] args) {
        /*
         * 注意，方法的重写不同于之前的方法重载，不要搞混了，方法重载是为某个方法提供更多种类，而方法的重写是覆盖原有的方法实现，比如我们
         * 现在不希望使用Object类中提供的equals方法
         */
        Plant plant1 = new Plant("小明", 0, "男");
        Plant plant2 = new Plant("小明", 0, "男");
        //此时由于三个属性完全一致，所以说判断结果为真，即使是两个不同的对象
        System.out.println(plant1.equals(plant2));

        String s = plant1.toString();
        System.out.println(s);

        //注意：我们如果不希望子类重写某个方法，我们可以在方法前面添加final关键字，表示这个方法已经是最终形态

        //或者如果父类中方法的可见性为private，那么子类同样无法访问，也就不能重写，但是可以定义同名方法
        //虽然这里可以编译通过，但是并不是对父类方法的重写，仅仅是子类自己创建的一个新方法

        //还有，我们在重写父类方法时，如果希望调用父类原本的方法实现，那么同样可以使用super关键字

        //访问权限问题，子类在重写父类方法时，不能降低父类方法中的可见性
        //因为子类实际上可以当作父类使用，如果子类的访问权限比父类还低，那么在被当作父类使用时，就可能出现无视访问权限
        //调用的情况，这样肯定是不行的，但是相反的，我们可以在子类中提升权限
        //总之，子类重写的方法权限不能比父类还低
    }
}
