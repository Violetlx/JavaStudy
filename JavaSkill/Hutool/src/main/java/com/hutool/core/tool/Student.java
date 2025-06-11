package com.hutool.core.tool;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学生类
 * @author lixuan
 * @Date 2024/12/28 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends CloneSupport<Student> implements Serializable {
    private String name;
    private int age;

    public void doSomeThing() {
        System.out.println(name+"在学习！");
    }
}
