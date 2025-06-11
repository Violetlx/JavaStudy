package com.hutool.core.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * 反射测试类
 * @author lixuan
 * @Date 2024/12/28 16:45
 */
public class TestClass {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public List<String> getList(){
        return new ArrayList<>();
    }

    public Integer intTest(Integer integer) {
        return 1;
    }
}
