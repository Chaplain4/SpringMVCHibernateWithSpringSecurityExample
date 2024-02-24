package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;

import java.util.List;

public interface AuthorDAO {
    Author findById(int id);

    void save(Author author);

    void deleteById(int id);

    List<Author> findAllAuthors();

//    List<Book> findAllBooksByAuthor(int authorId);
}
