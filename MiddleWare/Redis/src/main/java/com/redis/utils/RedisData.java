package com.redis.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lixuan
 */
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
