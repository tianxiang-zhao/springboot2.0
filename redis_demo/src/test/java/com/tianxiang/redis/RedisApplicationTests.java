package com.tianxiang.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {

        ValueOperations ops=stringRedisTemplate.opsForValue();
        ops.set("userName","jerry");
        Object name=ops.get("userName");
        System.out.println(name);
    }


}
