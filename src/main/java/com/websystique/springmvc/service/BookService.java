package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.model.Office;

import java.util.List;

public interface BookService {
    Book findById(int id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBookById(int id);

    List<Author> findAllAuthorsByBook(int bookId);

    List<Book> findAllBooks();
}
