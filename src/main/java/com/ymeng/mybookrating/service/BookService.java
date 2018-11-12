package com.ymeng.mybookrating.service;

import com.ymeng.mybookrating.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public Book getBook(long id);

    public void saveBook(Book book);

    public void deleteBook(long id);

    public void deleteAllBooks();

    public void updateBook(Book book);

    public boolean isBookExist(Book book);
}
