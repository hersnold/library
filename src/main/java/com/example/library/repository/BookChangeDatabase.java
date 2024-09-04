package com.example.library.repository;

import com.example.library.model.Book;

import java.io.FileWriter;
import java.io.IOException;

public class BookChangeDatabase {

    public void logChanges(Book oldBook, Book newBook) throws IOException {
        if (!oldBook.equals(newBook)) {
            FileWriter writer = new FileWriter("modified_books.log", true);
            writer.write("Changes detected in book ID: " + newBook.getId() + "\n");
            writer.write("Old Data: " + oldBook + "\n");
            writer.write("New Data: " + newBook + "\n");
            writer.close();
        }
    }
}
