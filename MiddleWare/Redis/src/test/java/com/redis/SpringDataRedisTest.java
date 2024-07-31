package com.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * @author lixuan
 * @Date 2024/7/30 10:50
 */
@SpringBootTest
public class SpringDataRedisTest {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    // JSON序列化工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testString() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "虎哥");
        // 获取string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testSaveUser() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("虎哥");
        user.setAge(18);
        user.setEmail("1111@qq.conm");
        redisTemplate.opsForValue().set("user:1", user);
        System.out.println("user = " + user);
        UserEntity user1 = (UserEntity) redisTemplate.opsForValue().get("user");
        System.out.println("user1 = " + user1);
    }

    @Test
    void testForString() {
        // 写入一条String数据
        stringRedisTemplate.opsForValue().set("name", "虎哥");
        // 获取string数据
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    /**
     * 推荐使用String序列化
     * @throws JsonProcessingException
     */
    @Test
    void testSaveUserEntity() throws JsonProcessingException {
        // 创建对象
        UserEntity user = new UserEntity();
        user.setId(2L);
        user.setName("杰哥");
        user.setAge(18);
        user.setEmail("1111@qq.conm");
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user:2", json);

        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:2");
        // 手动反序列化
        UserEntity user1 = mapper.readValue(jsonUser, UserEntity.class);
        System.out.println("user1 = " + user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:3", "name", "Tom");
        stringRedisTemplate.opsForHash().put("user:3", "age", "18");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println("entries = " + entries);

    }
}
