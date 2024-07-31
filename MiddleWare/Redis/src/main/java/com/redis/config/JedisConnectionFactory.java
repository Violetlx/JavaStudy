package com.redis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池
 * @author lixuan
 * @Date 2024/7/30 9:32
 */
public class JedisConnectionFactory {

    private static JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数数
        poolConfig.setMaxTotal(8);
        //最大空闲连接数
        poolConfig.setMaxIdle(8);
        //最小空闲连接数
        poolConfig.setMinIdle(0);
        //超时时间
        poolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象，参数：连接池配置、服务端ip、服务端端口、超时时间、密码
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379, 1000, null);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
