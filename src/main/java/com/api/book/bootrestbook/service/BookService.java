package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entity.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "javaScript the definite Guid", "David falangan"));
        list.add(new Book(2, "Eat that frog", "Brain Tracy"));
        list.add(new Book(3, "Rich Dad Poor Dad", "Robert T Kiosarr"));
        list.add(new Book(4, "wings of fire", "APJ abdul kalam"));
        list.add(new Book(5, "bela furabar age", "APJ abdul kalam"));
    }

    public List<Book> getAllBook() {
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public Book addBook(Book b) {
        list.add(b);
        return b;

    }

    public void deleteBook(int bid) {
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

    }

    public void updateBook(Book book, int bookId) {
        list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());

            }
            return b;
        }).collect(Collectors.toList());
    }

}
