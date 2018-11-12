package com.ymeng.mybookrating.service;

import com.ymeng.mybookrating.model.Book;
import com.ymeng.mybookrating.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public BookServiceImpl() {
        super();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if ( bookOptional.isPresent() )
            return bookRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.insert(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public boolean isBookExist(Book book) {
        Book foundBook = this.getBook(book.getId());
        return (foundBook != null);
    }
}
