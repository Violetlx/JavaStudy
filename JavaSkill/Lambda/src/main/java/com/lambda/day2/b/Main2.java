package com.lambda.day2.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 12-闭包-Closure-1
 * @author lixuan
 * @Date 2024/7/19 8:58
 */
public class Main2 {
    /*
       1、什么是闭包？
       函数对象和它外界变量绑定在一起
       2、闭包的限制？
       闭包变量必须是final或effective final
       3、闭包的作用？
       给函数执行提供数据的手段
     */

    //闭包作用，给函数对象提供参数以外的数据

    public static void main(String[] args) throws IOException {
        //创建10个热舞对象，并且每个任务对象给一个任务编号
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int k = i +1;
            Runnable task = () -> System.out.println(Thread.currentThread()+"===>执行任务"+k);
            list.add(task);
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);
        list.forEach(executor::submit);
        System.in.read();
    }
}
