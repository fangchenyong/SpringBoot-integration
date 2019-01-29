package com.joey.mapper;

import com.joey.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 〈〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
public interface BooksMapper {

    @Select("select * from books where id = #{id}")
    public Books getBooksById(@Param("id") Integer id);

    @Select("select * from books where title =#{title}")
    public Books getBooksByTitle(@Param("title") String title);

}
