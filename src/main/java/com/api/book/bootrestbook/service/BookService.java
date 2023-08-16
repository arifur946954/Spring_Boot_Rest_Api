package com.api.book.bootrestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entity.Book;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "javaScript the definite Guid", "David falangan"));
    // list.add(new Book(2, "Eat that frog", "Brain Tracy"));
    // list.add(new Book(3, "Rich Dad Poor Dad", "Robert T Kiosarr"));
    // list.add(new Book(4, "wings of fire", "APJ abdul kalam"));
    // list.add(new Book(5, "bela furabar age", "APJ abdul kalam"));
    // list.add(new Book(6, "post manr ", "kham abul kalam azad"));

    // }

    public List<Book> getAllBook() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        System.out.println("this is test case for spring boot");
        return list;

    }

    public Book getBookById(int id) {

        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

    }

    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;

    }
    // 1,2,3,4,5,6,7,8
    // 5
    // 7!=5
    // 1,2,3,4,6,7,8

    public void deleteBook(int bid) {
        bookRepository.deleteById(bid);
        // list = list.stream().filter(book -> book.getId() !=
        // bid).collect(Collectors.toList());

    }

    public void updateBook(Book book, int bookId) {

        // list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());

        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        bookRepository.save(book);
    }

}
