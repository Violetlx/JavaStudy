package com.hutool.core.tool;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象工具-ObjectUtil
 * @author lixuan
 * @Date 2024/12/28 14:57
 */
public class Main7 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
        System.out.println("---------------------------");
        test4();
        System.out.println("---------------------------");
        test5();
        System.out.println("---------------------------");
        test6();
        System.out.println("---------------------------");
        test7();
        System.out.println("---------------------------");
        test8();
    }

    /**
     * 1 默认值
     */
    private static void test1() {
        final String dateStr = null;
        // 此处判断如果dateStr为null，则调用`Instant.now()`，不为null则执行`DateUtil.parse`
        Instant result1 = ObjectUtil.defaultIfNull(dateStr,
                () -> DateUtil.parse(dateStr, DatePattern.NORM_DATETIME_PATTERN).toInstant(), Instant.now());
        System.out.println("test1--result1==>"+result1);

        //结果：
        //test1--result1==>2024-12-28T08:53:35.248301200Z
    }

    /**
     * 2 ObjectUtil.eaqual
     */
    private static void test2() {
        final String str1 = "str1";
        final String str2 = "str2";
        final String str3 = "str1";
        // 比较两个对象是否相等，如果两个对象为null，则返回true
        boolean result1 = ObjectUtil.equal(str1, str2);
        System.out.println("test2--result1==>"+result1);
        // 比较两个对象是否相等，如果两个对象为null，则返回false
        boolean result2 = ObjectUtil.equal(str1, str3);
        System.out.println("test2--result2==>"+result2);

        //结果：
        //test2--result1==>false
        //test2--result2==>true
    }

    /**
     * 3 ObjectUtil.length
     */
    private static void test3() {
        int[] array = new int[]{1,2,3,4,5};

        // 5
        int length = ObjectUtil.length(array);
        System.out.println("test3--length==>"+length);

        Map<String, String> map = new HashMap<>();
        map.put("a", "a1");
        map.put("b", "b1");
        map.put("c", "c1");

        // 3
        length = ObjectUtil.length(map);
        System.out.println("test3--length==>"+length);

        //结果：
        //test3--length==>5
        //test3--length==>3
    }

    /**
     * 4 ObjectUtil.contains
     */
    private static void test4() {
        int[] array = new int[]{1,2,3,4,5};
        // true
        boolean contains = ObjectUtil.contains(array,1);
        System.out.println("test4--contains==>"+contains);

        boolean contains1 = ObjectUtil.contains(array, 6);
        System.out.println("test4--contains1==>"+contains1);

        //结果：
        //test4--contains==>true
        //test4--contains1==>false
    }

    /**
     * 5 判断是否为 null
     */
    private static void test5() {
        final String str1 = null;
        final String str2 = "str2";
        // true
        boolean result1 = ObjectUtil.isNull(str1);
        System.out.println("test5--result1==>"+result1);
        // false
        boolean result2 = ObjectUtil.isNull(str2);
        System.out.println("test5--result2==>"+result2);

        boolean notEmpty = ObjectUtil.isNotEmpty(str1);
        System.out.println("test5--notEmpty==>"+notEmpty);

        boolean notEmpty1 = ObjectUtil.isNotEmpty(str2);
        System.out.println("test5--notEmpty1==>"+notEmpty1);

        //结果：
        //test5--result1==>true
        //test5--result2==>false
        //test5--notEmpty==>false
        //test5--notEmpty1==>true
    }

    /**
     * 6 克隆
     */
    private static void test6() {
        Student student = new Student("张三", 18);
        System.out.println("test6--student==>"+student);
        Student clone = ObjectUtil.clone(student);
        System.out.println("test6--clone==>"+clone);

        // OK
        clone.doSomeThing();

        // 返回克隆后的对象，如果克隆失败，返回原对象
        Student cloneIfPossible = ObjectUtil.cloneIfPossible(student);
        System.out.println("test6--cloneIfPossible==>"+cloneIfPossible);

        // 序列化后拷贝流的方式克隆，对象必须实现Serializable接口
        Student cloneByStream = ObjectUtil.cloneByStream(student);
        System.out.println("test6--cloneByStream==>"+cloneByStream);

        //结果：
        //test6--student==>Student(name=张三, age=18)
        //test6--clone==>Student(name=张三, age=18)
        //张三在学习！
        //test6--cloneIfPossible==>Student(name=张三, age=18)
        //test6--cloneByStream==>Student(name=张三, age=18)
    }

    /**
     * 7 序列化和反序列化
     */
    private static void test7() {
        Student student = new Student("张三", 18);
        System.out.println("test7--student==>"+student);
        // 序列化
        byte[] bytes = ObjectUtil.serialize(student);
        System.out.println("test7--bytes==>"+bytes);
        // 反序列化
        Student deserialize = ObjectUtil.deserialize(bytes);
        System.out.println("test7--deserialize==>"+deserialize);

        //结果：
        //test7--student==>Student(name=张三, age=18)
        //test7--bytes==>[B@61a52fbd
        //test7--deserialize==>Student(name=张三, age=18)
    }

    /**
     * 8 判断基本类型
     */
    private static void test8() {
        int a = 1;

        // true
        final boolean basicType = ObjectUtil.isBasicType(a);
        System.out.println("test1--basicType==>"+basicType);

        String b = "2";
        // false
        boolean basicType1 = ObjectUtil.isBasicType(b);
        System.out.println("test1--basicType1==>"+basicType1);

        //结果：
        //test1--basicType==>true
        //test1--basicType1==>false
    }

}
