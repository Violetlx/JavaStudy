package com.cloud.service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 欢迎接口
 * @author lixuan
 */
@RestController
@RequestMapping("hi")
@Tag(name = "欢迎接口")
public class HelloController {

    private final Map<String, AtomicInteger> countMap = new HashMap<>();

    @GetMapping
    @Operation(summary = "欢迎访问")
    public String hello(HttpServletRequest request) throws InterruptedException {
        Thread.sleep(300);
        String ip = request.getRemoteAddr();
        AtomicInteger ai = countMap.get(ip);
        if (ai == null) {
            ai = new AtomicInteger(0);
            countMap.put(ip, ai);
        }
        return String.format("<h5>欢迎访问黑马商城, 这是您第%d次访问<h5>", ai.incrementAndGet());
    }
}
