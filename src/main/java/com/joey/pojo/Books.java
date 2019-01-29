package com.joey.pojo;

import java.io.Serializable;

/**
 * 〈books实体类〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
public class Books implements Serializable{

    public Integer id;
    public String title;
    public String price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
