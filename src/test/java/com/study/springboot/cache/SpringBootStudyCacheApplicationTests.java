package com.study.springboot.cache;

import com.study.springboot.cache.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudyCacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Department> departmentRedisTemplate ;

    @Test
    public void contextLoads() {
        //redisTemplate.opsForValue().append("k1","hello");
        //redisTemplate.opsForValue().append("k2","_world");
//        stringRedisTemplate.opsForValue().append("k1","helloK1");
//        stringRedisTemplate.opsForValue().append("k2","hellok2");
//        stringRedisTemplate.opsForList().leftPush("list1","list01 list02 list03");
//        stringRedisTemplate.opsForList().leftPush("list1","list02");

        departmentRedisTemplate.opsForValue().set("dept",new Department(4,"deptNameTest"));
    }

}
