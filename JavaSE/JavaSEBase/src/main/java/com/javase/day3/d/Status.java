package com.javase.day3.d;

/**
 * 枚举类
 * @author 1045754
 */

public enum Status {//enum表示这是一个枚举类，枚举类的语法稍微有些不一样
    /**
     * 枚举类中定义的变量，必须使用public static final修饰
     * <p>
     * 直接写每个状态的名字即可，最后面分号可以不打，但是推荐打上
     */
    //RUNNING, STUDY, SLEEP;


    /**
     * //无参构造方法被覆盖，创建枚举需要添加参数（本质就是调用的构造方法）
     */
    RUNNING("跑步"), STUDY("学习"), SLEEP("睡觉");

    /**
     * //枚举的成员变量
     */
    private final String name;
    Status(String name){    //覆盖原有构造方法（默认private，只能内部使用！）
        this.name = name;
    }

    public String getName() {   //获取封装的成员变量
        return name;
    }

}
