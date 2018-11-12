package com.ymeng.mybookrating.controller;

import com.ymeng.mybookrating.model.Book;
import com.ymeng.mybookrating.service.BookService;
import com.ymeng.mybookrating.service.BookServiceImpl;
import com.ymeng.mybookrating.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController() {
        System.out.println("BookController()");
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllUsers() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable("id") long id) {
        Book book = bookService.getBook(id);

        System.out.println(" Book {" + book + "} for id " + id);

        if (book == null) {
            return new ResponseEntity(
                new CustomErrorType("Book with id " + id + " not found"),
                HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
        if (bookService.isBookExist(book)) {
            return new ResponseEntity(
                new CustomErrorType("Unable to create. A Book " +
                    book.toString() + " already exist."),
                HttpStatus.CONFLICT
            );
        }
        bookService.saveBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/book/{id}").buildAndExpand(book.getId()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody Book book) {

        Book currentBook = bookService.getBook(id);

        if (currentBook == null) {
            return new ResponseEntity(
                new CustomErrorType("Unable to update. Book with id " + id + " not found."),
                HttpStatus.NOT_FOUND
            );
        }

        if (id != book.getId()) {
            return new ResponseEntity(
                new CustomErrorType("Mismatch between book id " + id + " and request body { " + book + " }"),
                HttpStatus.CONFLICT
            );
        }

        bookService.updateBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        Book book = bookService.getBook(id);
        if (book == null) {
            return new ResponseEntity(
                new CustomErrorType("Unable to delete. Book with id " + id + " not found."),
                HttpStatus.NOT_FOUND
            );
        }

        bookService.deleteBook(id);

        return new ResponseEntity<Book>(HttpStatus.OK);
    }


    @RequestMapping(value = "/books", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteAllBooks() {

        bookService.deleteAllBooks();

        return new ResponseEntity<Book>(HttpStatus.OK);
    }
}