package com.joey.service;

import com.joey.pojo.Books;

public interface BooksService {

    public Books getBooksById(Integer id);

    public Books getBooksByTitle(String title);

    public String getRedisCluster();
}
