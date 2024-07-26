package com.lambda.day1;

/**
 * 01-合格的函数例二
 * @author lixuan
 * @Date 2024/7/18 9:28
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(pray("张三"));
        System.out.println(pray("张三"));
        System.out.println(pray("张三"));
//        buddha.name = "魔王";
        System.out.println(pray("张三"));

        //pray不是一个合格的函数

        //对比Main1和Main2发现，如果你的函数引入了一个外部可变的数据，那他就是不合格的

        //让他合格，只要保证外部引用的数据不可变就行
    }

//    static class Buddha {
//        String name;
//
//        public Buddha(String name) {
//            this.name = name;
//        }
//    }

    //相当于只有get方法，没有set方法
    record Buddha(String name){}

    static Buddha buddha = new Buddha("如来");

    static String pray(String person) {
        return ("我" + person + "向【" + buddha.name+"】虔诚的祈祷！");
    }
}
