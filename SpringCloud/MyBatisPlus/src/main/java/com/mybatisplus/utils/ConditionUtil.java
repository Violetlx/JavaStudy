package com.mybatisplus.utils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取查询条件
 * @author lixuan
 * @Date 2024/8/8 8:41
 */
public class ConditionUtil {

    /**
     * 构建查询条件
     *
     * @param entity 实体对象
     * @param <T> 实体类型
     * @return QueryWrapper<T> 查询条件
     */
    public static <T> QueryWrapper<T> buildQueryWrapper(T entity, Class<T> entityClass) {
        QueryWrapper<T> queryWrapper = Wrappers.query();

        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            // 排除被 @TableField(exist = false) 注解的字段
            TableField tableField = field.getAnnotation(TableField.class);
            if (tableField != null && !tableField.exist()) {
                continue;
            }

            try {
                Object value = field.get(entity);
                // 只处理非 null 的字段
                if (value != null) {
                    String fieldName = (tableField != null && !tableField.value().isEmpty())
                            ? tableField.value()
                            : field.getName();

                    // 使用反射获取 getter 方法
                    String methodName = "get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
                    Method getterMethod = entityClass.getMethod(methodName);
                    Object fieldValue = getterMethod.invoke(entity);

                    // 动态构建查询条件
                    queryWrapper.eq(fieldName, fieldValue);
                }
            } catch (Exception e) {
                e.printStackTrace(); // 处理异常
            }
        }

        return queryWrapper;
    }
}
