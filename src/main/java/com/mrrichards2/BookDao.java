package com.mrrichards2;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BookDao {
    public List<Book> getBooks() {
        return Stream.of(
                        new Book(101, "Crime and Punishment", 10, 100),
                        new Book(58, "Gravity's Rainbow", 4, 60),
                        new Book(205, "Catcher in the Rye", 1, 5),
                        new Book(809, "Learning Java", 2, 100))
                .collect(Collectors.toList());
    }
}
