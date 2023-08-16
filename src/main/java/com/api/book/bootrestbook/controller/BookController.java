package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entity.Book;
import com.api.book.bootrestbook.service.BookService;

@RestController
// @RequestMapping("/api/books")

public class BookController {
    @Autowired
    private BookService bookservices;

    // get all book handeler
    @GetMapping("/books")

    public ResponseEntity<List<Book>> getBook() {
        // Book book = new Book(123, "Atomic Habbit", "James Clear");
        List<Book> list = this.bookservices.getAllBook();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
    }

    // get single book handaler
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookB(@PathVariable("id") int id) {
        Book book = this.bookservices.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(book));
        }

    }

    // post book handaller

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookservices.addBook(book);
        return b;

    }

    // @PostMapping("/")
    // public Book addBook(@RequestBody Book book) {
    // Book b = this.bookservices.addBook(book);
    // /// return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
    // return b;

    // }

    // delete boook maping
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        this.bookservices.deleteBook(bookId);
    }

    @PutMapping("/books/{bookid}")
    public void updateData(@RequestBody Book book, @PathVariable("bookid") int bookId) {
        this.bookservices.updateBook(book, bookId);
    }

}
