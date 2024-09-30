package com.sa.token.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录
 * @author lixuan
 * @Date 2024/9/30 12:05
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 获取当前会话登录id http://localhost:8081/user/getLoginId
    @RequestMapping("getLoginId")
    public Object getLoginId() {
        Object loginId = StpUtil.getLoginId();
        System.out.println("当前会话的 LoginId 为：" + loginId);

        // 类似查询API还有：
        // 获取当前会话账号id, 并转化为`String`类型
        String id1 = StpUtil.getLoginIdAsString();
        System.out.println("id1 = " + id1);
        // 获取当前会话账号id, 并转化为`int`类型
        int id2 = StpUtil.getLoginIdAsInt();
        System.out.println("id2 = " + id2);
        // 获取当前会话账号id, 并转化为`long`类型
        long id3 = StpUtil.getLoginIdAsLong();
        System.out.println("id3 = " + id3);

        // 获取当前会话账号id, 如果未登录，则返回 null
        StpUtil.getLoginIdDefaultNull();

        // 获取当前会话账号id, 如果未登录，则返回默认值 （`defaultValue`可以为任意类型）
        StpUtil.getLoginId("T defaultValue");

        return StpUtil.getLoginId();
    }

    // Token 查询 http://localhost:8081/user/getToken
    @RequestMapping("/getToken")
    public String getToken() {
        // 获取当前会话的 token 值
        String tokenValue = StpUtil.getTokenValue();
        System.out.println("当前会话的 token 值 = " + tokenValue);

        // 获取当前`StpLogic`的 token 名称
        String tokenName = StpUtil.getTokenName();
        System.out.println("当前`StpLogic`的 token 名称 = " + tokenName);

        // 获取指定 token 对应的账号id，如果未登录，则返回 null
        Object loginIdByToken = StpUtil.getLoginIdByToken(tokenValue);
        System.out.println("指定 token 对应的账号id，如果未登录，则返回 null = " + loginIdByToken);

        // 获取当前会话剩余有效期（单位：s，返回-1代表永久有效）
        long tokenTimeout = StpUtil.getTokenTimeout();
        System.out.println("当前会话剩余有效期（单位：s，返回-1代表永久有效） = " + tokenTimeout);

        // 获取当前会话的 token 信息参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        System.out.println("当前会话的 token 信息参数 = " + tokenInfo);

        return StpUtil.getTokenInfo().toString();
    }

}