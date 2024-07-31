package com.redis;

import com.redis.config.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;

@SpringBootTest
class JedisTest {

    private Jedis jedis;

    /**
     * 建立连接
     */
    @BeforeEach
    void setUp() {
        // 1.建立连接
        //普通连接
//        jedis = new Jedis("127.0.0.1", 6379);
        //使用Jedis连接池连接
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
//        jedis.auth("123321");
        // 3.选择库
        jedis.select(2);
    }

    /**
     * 操作，使用Jedis，方法名称与命令名称一致
     */
    @Test
    void testString() {
        // 存入数据
        String result = jedis.set("name", "Jerry");
        System.out.println("result = " + result);
        // 获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testHash() {
        // 插入hash数据
        jedis.hset("user:1", "name", "Jack");
        jedis.hset("user:1", "age", "21");

        // 获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }


    /**
     * 释放资源
     */
    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
