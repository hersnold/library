package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookChangeDatabase;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void updateBook(Long id, Book updatedBook) throws IOException {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            BookChangeDatabase logger = new BookChangeDatabase();
            logger.logChanges(existingBook.get(), updatedBook);
            bookRepository.save(updatedBook);
        }
    }


    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}

