package com.cloud.service.interceptor;

import com.cloudcommon.utils.UserContext;
import com.cloud.service.utils.JwtTool;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * 登录拦截器
 * @author lixuan
 */
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final JwtTool jwtTool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求头中的 token
        String token = request.getHeader("authorization");
        // 2.校验token
        Long userId = jwtTool.parseToken(token);
        // 3.存入上下文
        UserContext.setUser(userId);
        // 4.放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清理用户
        UserContext.removeUser();
    }
}
