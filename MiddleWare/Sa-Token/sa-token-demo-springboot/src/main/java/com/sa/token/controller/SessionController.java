package com.sa.token.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SessionController
 * @author lixuan
 * @Date 2024/10/8 10:54
 */
@RestController
@RequestMapping("/session/")
public class SessionController {

    //Account-Session http://localhost:8081/session/account
    @SaIgnore
    @RequestMapping("account")
    public String get() {
        // 获取当前账号 id 的 Account-Session (必须是登录后才能调用)
        SaSession session = StpUtil.getSession();
        System.out.println("session ===> "+session);

        // 获取当前账号 id 的 Account-Session, 并决定在 Session 尚未创建时，是否新建并返回
        StpUtil.getSession(true);

        // 获取账号 id 为 10001 的 Account-Session
        SaSession sessionByLoginId = StpUtil.getSessionByLoginId(10001);
        System.out.println("sessionByLoginId ===> "+sessionByLoginId);

        // 获取账号 id 为 10001 的 Account-Session, 并决定在 Session 尚未创建时，是否新建并返回
        StpUtil.getSessionByLoginId(10001, true);

        // 获取 SessionId 为 xxxx-xxxx 的 Account-Session, 在 Session 尚未创建时, 返回 null
        StpUtil.getSessionBySessionId("xxxx-xxxx");

        return "get session";
    }
}
