package com.javase.day5.a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商店泛型类(泛型类)
 * @author lixuan
 * @Date 2024/6/17 14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store<T> { //泛型类需要使用<>，我们需要在里面添加1 - N个类型变量

    String name;
    String id;
    /**
     * T会根据使用时提供的类型自动变成对应类型
     */
    T value;

    //这里T可以是任何类型，但是一旦确定，那么就不能修改了
}
