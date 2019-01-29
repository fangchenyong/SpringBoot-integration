package com.joey.service.impl;

import com.joey.mapper.BooksMapper;
import com.joey.pojo.Books;
import com.joey.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * 〈〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private JedisCluster jedisCluster;

    @Cacheable(value="mybook")
    @Override
    public Books getBooksById(Integer id){
        System.out.println("从数据库中查询。。。");
        return booksMapper.getBooksById(id);
    };

    @Override
    public Books getBooksByTitle(String title){
        return booksMapper.getBooksByTitle(title);
    };

    @Override
    public String getRedisCluster() {
        jedisCluster.set("id","joey");
        return jedisCluster.get("id");
    }
}
