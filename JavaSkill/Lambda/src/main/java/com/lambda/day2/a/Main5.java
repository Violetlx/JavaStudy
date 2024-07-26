package com.lambda.day2.a;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 06-方法引用-3
 * @author lixuan
 * @Date 2024/7/18 15:45
 */
public class Main5 {
    static class Student {
        private final String name;
        private final Integer age;

        public Student() {
            this.name = "某人";
            this.age = 18;
        }

        public Student(String name) {
            this.name = name;
            this.age = 18;
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        //Supplier 生成 不给参数、返回结果 (无参构造)
        Supplier<Student> s1 = Student::new;
        //Function 给一个参数、返回结果
        Function<String, Student> s2 = Student::new;
        //BiFunction 给两个参数、返回结果
        BiFunction<String, Integer, Student> s3 = Student::new;

        System.out.println(s1.get());
        System.out.println(s2.apply("张三"));
        System.out.println(s3.apply("李四", 25));
    }
}
