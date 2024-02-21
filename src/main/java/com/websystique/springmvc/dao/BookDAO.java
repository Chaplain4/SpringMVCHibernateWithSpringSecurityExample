package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;

import java.util.List;

public interface BookDAO {
    Book findById(int id);

    void save(Book book);

    void deleteById(int id);

    List<Author> findAllAuthorsByBook(int bookId);

    List<Book> findAllBooks();
}
