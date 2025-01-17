package com.example.library.repository;

import com.example.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void delete(Long id);
}

