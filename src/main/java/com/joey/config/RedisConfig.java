package com.joey.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈redis集群配置〉
 *
 * @author Joey
 * @create 2019-01-14
 * @since 1.0.0
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes;

    @Bean
    public JedisCluster getJedisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        try {
            String[] redisnodes = redisNodes.split(",");
            for (String node:redisnodes){
                String[] arr = node.split(":");
                HostAndPort hostAndPort = new HostAndPort(arr[0], Integer.parseInt(arr[1]));
                nodes.add(hostAndPort);
            }
        }
        catch (Exception e){
            System.out.println("集群节点配置有误");
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //配置password否则会报权限错误
        JedisCluster cluster = new JedisCluster(nodes,0,0,500,"123456",jedisPoolConfig);
        return cluster;
    }
}
