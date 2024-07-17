package com.javase.day3.d;

/**
 * 枚举类
 * @author lixuan
 * @Date 2024/6/12 11:07
 */
public class Main {
    /**
     * 枚举类的使用非常方便，其实枚举类的本质就是一个普通的类，但是它继承自Enum类，我们定义的每一个状态就是一个public static final
     * 的Status类型成员变量
     */
    public static void main(String[] args) {
        Student student = new Student();
        student.setStatus(Status.RUNNING);
        System.out.println(student.getStatus());
        System.out.println(student.getStatus().getName());
    }
}
