package com.javase.day3.entity;

/**
 * 测试类(类的封装)
 * @author lixuan
 * @Date 2024/5/29 14:30
 */
public class Test {

    //通过Dog狗类的这种方式，我们可以实现单例模式

    private static Test instance;
    private Test() {
    }

    public static Test getInstance() {
        if (instance == null) {
            instance = new Test();
        }
        return instance;
    }

    //单例模式就是全局只能使用这一个对象，不能创建更多的对象，我们可以封装成这样。
}
