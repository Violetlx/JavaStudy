package com.lambda.day2.a;

import java.util.stream.Stream;

/**
 * 06-方法引用-1
 * @author lixuan
 * @Date 2024/7/18 15:14
 */
public class Main3 {
    public static void main(String[] args) {
        /**
         * 需求：挑选出所有男性学生
         */
        Stream<Student> studentStream = Stream.of(
                new Student("张无忌", "男"),
                new Student("周芷若", "女"),
                new Student("宋青书", "男")
        );

        //类名::静态方法引用
        studentStream
                //.filter(student -> "男".equals(student.sex()))
                .filter(Main3::isMale)
                //.forEach(System.out::println);
                .forEach(Main3::abc);

        //介绍方法引用

        //forEach方法：逐一输出流中的元素(消费)
        /**
         * (Student stu) -> System.out.println(stu)
         * 方法引用 ==> 类名::静态方法
         * System.out::println
         */

        //filter方法：挑选出符合条件的元素(筛选)
        /**
         * (Student stu) -> "男".equals(stu.sex())
         */

        System.out.println("==================");

        /**
         * 需求：挑选出所有男性学生
         */
        Stream<Student> studentStream1 = Stream.of(
                new Student("张无忌", "男"),
                new Student("周芷若", "女"),
                new Student("宋青书", "男")
        );

        //类名::非静态方法引用
        studentStream1
                .filter(Student::isMale)
                .forEach(Student::print);

    }

    public static boolean isMale(Student stu) {
        return "男".equals(stu.sex());
    }

    public static void abc(Student stu) {
        System.out.println(stu);
    }

    record Student(String name, String sex) {

        public void print() {
            System.out.println(this);
        }
        /**
         * Student::print
         * (stu) -> stu.print()
         */

        public boolean isMale() {
            return "男".equals(this.sex);
        }
        /**
         * Student::isMile
         * (stu) -> stu.isMale()
         */
    }
}
