package com.example.graphqlacquaintance;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQlController {
    private final BookService bookService;

    public GraphQlController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public String greeting(@Argument String name) {
        return "Привет, " + name + "! Это ответ Spring for GraphQL.";
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument String author) {
        return bookService.add(title, author);
    }
}
