package com.javase.day5.a;

/**
 * 泛型与多态
 * @author lixuan
 * @Date 2024/6/17 15:03
 */
public class Main3 {
    public static void main(String[] args) {
        A a = new A();
        Integer i = a.test();
        System.out.println(i);

        B<String> b = new B<>();
        String s = b.test();
        System.out.println(s);
    }

    static class A implements Study<Integer> {
        //在实现接口或是继承父类时，如果子类是一个普通类，那么可以直接明确对应类型
        @Override
        public Integer test() {
            return null;
        }
    }

    static class B<T> implements Study<T> {
        //让子类继续为一个泛型类，那么可以不用明确
        @Override
        public T test() {
            return null;
        }
    }

}
