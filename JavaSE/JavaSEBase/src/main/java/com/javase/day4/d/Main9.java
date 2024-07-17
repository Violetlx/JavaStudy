package com.javase.day4.d;

/**
 * 方法引用
 * @author lixuan
 * @Date 2024/6/13 14:55
 */
public class Main9 {
    public static void main(String[] args) {
        //方法引用就是及那个一个已实现的方法，直接作为接口中抽象方法的实现(当然前提是方法定义得一样才行)

        Read read = (a,b)-> a+b;
        System.out.println(read.sum(1,2));

        System.out.println("----------------------");

        //Integer中提供了默认求和方法

        //直接使用Integer为我们通过好的求和方法
        Read read1 = (a,b)-> Integer.sum(a,b);
        System.out.println(read1.sum(1,2));

        //使用双冒号来进行方法引用，静态方法使用 类名::方法名 的形式
        Read read2 = Integer::sum;
        System.out.println(read2.sum(1,2));

        //方法引用其实本质上就相当于将其他方法得实现，直接作为接口中抽象方法得实现，任何方法都可以通过方法引用作为实现

        //如果从普通成员方法，我们同样需要使用对象来进行方法使用
        Main9 main9 = new Main9();
        Study study =main9::lbwnb;
        study.study();

        //因为现在只需要一个String类型得返回值，由于String的构造方法在创建对象时也会得到一个String类型的结果，所以说
        //没错，构造方法也可以被引用，使用new表示
        Study study1 = String::new;

        //反正只要时符合接口中方法的定义，都可以直接进行方法引用
    }

    public String lbwnb(){
        return "卡布奇诺今犹在，不见当年倒茶人。";
    }
}
