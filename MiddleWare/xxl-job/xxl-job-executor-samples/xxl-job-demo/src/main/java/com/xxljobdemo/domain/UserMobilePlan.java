package com.xxljobdemo.domain;

import lombok.Data;

/**
 * @author lixuan
 * @Date 2024/7/17 21:18
 */
@Data
public class UserMobilePlan {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 备注
     */
    private String info;
}
