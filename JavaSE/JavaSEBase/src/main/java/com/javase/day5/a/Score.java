package com.javase.day5.a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成绩类(泛型)
 * @author lixuan
 * @Date 2024/6/17 14:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    String name;
    String id;
    /**
     * 因为Object是所有类型的父类，因此既可以存放Integer也能存放String
     */
    Object value;
}
