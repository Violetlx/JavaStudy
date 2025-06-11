package com.hutool.core.convert.converterregistry;

import cn.hutool.core.convert.Converter;

/**
 * 1.自定义转换器
 * @author lixuan
 * @Date 2024/12/18 17:15
 */
public class CustomConverter implements Converter<String> {
    @Override
    public String convert(Object value, String defaultValue) throws IllegalArgumentException {
        return "Custom: " + value.toString();
    }
}
