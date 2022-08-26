package com.mrrichards2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class BookService {

    @Autowired
    private BookDao bookDao;

    @GetMapping
    public List<Book> fetchBooks() {
        return bookDao.getBooks().stream().
                sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(BookService.class, args);
    }

}