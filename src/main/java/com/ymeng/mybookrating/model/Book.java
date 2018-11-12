package com.ymeng.mybookrating.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("book")
public class Book implements Serializable {

    @PrimaryKey(value = "id")
    private long id;

    @Column(value = "title")
    private String title;

    @Column(value = "author")
    private String author;

    // Required!
    public Book() {

    }

    public Book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() { return this.id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return this.author; }
    public void setAuthor(String author) { this.author = author; }

    public String toString() {
        return String.format(
            "{ id = %1$s, title = %2$s, author = %3$s }",
            getId(), getTitle(), getAuthor());
    }
}
