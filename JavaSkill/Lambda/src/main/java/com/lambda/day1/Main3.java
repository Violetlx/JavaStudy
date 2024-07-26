package com.lambda.day1;

/**
 * 01-合格的函数例三
 * @author lixuan
 * @Date 2024/7/18 9:40
 */
public class Main3 {
    /**
     * 成员方法算不算函数？
     */
    public static void main(String[] args) {
        //传的参数相同，返回的结果相同

        Student s1 = new Student("张三");
        System.out.println(s1.getName());//getName(s1)
        System.out.println(s1.getName());//getName(s1)

        Student s2 = new Student("李四");
        System.out.println(s2.getName());//getName(s2)
        System.out.println(s2.getName());//getName(s2)

        //合格的函数  无情、不变
    }

    /**
     * 学生类
     */
    static class Student {
        final String name;

        public Student(String name) {
            this.name = name;
        }

        //真正长相的成员方法
        public String getName(Student this) {
            return this.name;
        }
    }
}
