package com.hutool.core.tool;

/**
 * 定义枚举
 * @author lixuan
 * @Date 2024/12/30 15:34
 */
public enum TestEnum {
    /**
     * 测试1 2 3
     */
    TEST1("type1"), TEST2("type2"), TEST3("type3");

    private TestEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return this.type;
    }
}
