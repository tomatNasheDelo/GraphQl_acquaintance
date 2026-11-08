package com.example.graphqlacquaintance;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final AtomicLong nextId = new AtomicLong(3);
    private final List<Book> books = new CopyOnWriteArrayList<>(List.of(
            new Book("1", "Мастер и Маргарита", "Михаил Булгаков"),
            new Book("2", "Преступление и наказание", "Фёдор Достоевский")
    ));

    public List<Book> findAll() {
        return List.copyOf(books);
    }

    public Book findById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Book add(String title, String author) {
        Book book = new Book(Long.toString(nextId.getAndIncrement()), title, author);
        books.add(book);
        return book;
    }
}
