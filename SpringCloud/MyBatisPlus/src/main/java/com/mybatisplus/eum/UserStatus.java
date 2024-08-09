package com.mybatisplus.eum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 用户状态
 * @author lixuan
 * @Date 2024/8/9 9:02
 */
@Getter
public enum UserStatus {

    /**
     * 用户账号状态
     */
    NORMAL(1, "正常"),
    FREEZE(2, "冻结");

    @EnumValue
    private final int value;
    /**
     * JSON 响应时返回的属性值
     */
    @JsonValue
    private final String desc;

    UserStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
