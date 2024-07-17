package com.javase.day5.a;

/**
 * 泛型类
 * @author lixuan
 * @Date 2024/6/17 14:47
 */
public class Main2 {

    public static void main(String[] args) {
        Store<String> store = new Store<>("张三","001","百货店");
        System.out.println(store);

        //因为现在有了类型变量，在使用时同样需要跟上<>并在其中填写明确要使用的类型
        //这样我们就可以根据不同的类型进行选择了
        String value = store.getValue();
        System.out.println(value);

        //不能通过这个不确定的类型变量就去直接创建对象和对应的数组

        //具体类型不同的泛型类变量，不能使用不同的变量进行接收

        //如果要让某个变量支持引用确定了任意类型的泛型，那么可以使用?通配符
        Store<?> store1 = new Store<>();
        store1=new Store<String>();
        //但是注意，如果使用通配符，那么由于类型不确定，所以说具体类型同样会变成Object
        Object o = store1.getValue();

        /**
         * //泛型变量可以有多个
         * public class Test<A, B, C> {   //多个类型变量使用逗号隔开
         *     public A a;
         *     public B b;
         *     public C c;
         * }
         *
         * //使用的时候需指明类型
         */

        //泛型只能确定为一个引用类型，基本类型是不支持的
        //如果要存放基本数据类型的值，我们只能使用对应的包装类



    }
}
