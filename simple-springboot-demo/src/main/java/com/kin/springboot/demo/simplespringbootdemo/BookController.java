package com.kin.springboot.demo.simplespringbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> books = Arrays.asList(
                new Book(1l, "book1", "author1"),
                new Book(2l, "book2", "author2"),
                new Book(3l, "book3", "author3"),
                new Book(4l, "book4", "author4")
        );
        return books;
    }
}
