package com.api.book.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class BookController {
    @Autowired
    private BookService bookservices;

    // get all book handeler
    @GetMapping("/books")

    public List<Book> getBook() {
        // Book book = new Book(123, "Atomic Habbit", "James Clear");

        return this.bookservices.getAllBook();
    }

    // get single book handaler
    @GetMapping("/books/{id}")
    public Book getBookB(@PathVariable("id") int id) {
        return this.bookservices.getBookById(id);

    }

    // post book handaller
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookservices.addBook(book);
        return b;

    }

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
