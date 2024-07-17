package com.javase.day5.a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 存储类(泛型界限)
 * @author lixuan
 * @Date 2024/6/17 15:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Storage<T extends Number> {
    private final String name;
    private final String id;
    private final T value;
}
