package com.joey.controller;

import com.joey.pojo.Books;
import com.joey.service.BooksService;
import com.joey.service.impl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 〈〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/id/{id}")
    @ResponseBody
    public Books getBooks(@PathVariable("id") Integer id){
        return booksService.getBooksById(id);
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBook(Books books){
        Books book = new Books();
        book.setId(100);
        book.setPrice("23.3");
        book.setTitle("深入理解JVM");
        mongoTemplate.save(book);
        return "add success";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Books> findBooks(){
        return mongoTemplate.findAll(Books.class);
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String getRedisCluster(){
       return booksService.getRedisCluster();
    }
}