package com.javase.day4.b;

/**
 * 可变长参数
 * @author lixuan
 * @Date 2024/6/12 15:30
 */
public class Main3 {
    public static void main(String[] args) {//这个String[] args到底是个啥？？？
        //我们在使用时可以传入0-N个对应类型的实参
        Person person = new Person();
        //这里我们可以传入任意数量的字符串
        person.test("a","b","c","哥们在这跟你说唱");

        //那么我们在方法中怎么才能得到这些传入的参数呢？实际上可变长参数本质就是一个数组

        System.out.println();
        System.out.println("----------------------");

        //args
        for (String arg : args) {
            System.out.println(arg);
        }

        //实际上，这个是我们在执行Java程序
    }

    public void test(String... strings){   //strings这个变量就是一个String[]类型的
        //遍历打印数组中每一个元素
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 注意，如果同时存在其他参数，那么可变长参数只能放在最后
     */
    public void test(int a, int b, String... strings){

    }
}


