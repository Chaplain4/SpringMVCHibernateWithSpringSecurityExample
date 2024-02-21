package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;

import java.util.List;

public interface AuthorService {
    Author findById(int id);

    void saveAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthorById(int id);

    List<Author> findAllAuthors();

    List<Book> findAllBooksByAuthor(int authorId);
}
