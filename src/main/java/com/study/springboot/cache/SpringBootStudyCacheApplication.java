package com.study.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.study.springboot.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootStudyCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyCacheApplication.class, args);
    }

}
