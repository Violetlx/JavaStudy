package com.lambda.day2.a;

/**
 * 06-方法引用-练习
 * @author lixuan
 * @Date 2024/7/18 16:00
 */
public class Main9 {
    record Color(Integer red, Integer green, Integer blue) { }

    // 如果想用 `Color::new` 来构造 Color 对象，还应当补充哪些代码

    public static void main(String[] args) {
        // (Integer, Integer, Integer) -> Color
        TernaryFunction lambda = Color::new;

        Color white = lambda.create(255, 255, 255);
        System.out.println(white);
    }

    @FunctionalInterface
    interface TernaryFunction {
        Color create(Integer red, Integer green, Integer blue);
    }
}
