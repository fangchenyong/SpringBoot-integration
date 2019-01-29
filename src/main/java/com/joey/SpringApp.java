package com.joey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import redis.clients.jedis.Jedis;

/**
 * 〈启动类〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("com.joey.mapper")
@EnableCaching
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class,args);
    }
}
