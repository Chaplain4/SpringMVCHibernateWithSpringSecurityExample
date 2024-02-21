package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.AuthorDAO;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorDAO dao;

    @Override
    public Author findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveAuthor(Author author) {
        dao.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        Author entity = dao.findById(author.getId());
        if(entity!=null){
            entity.setId(author.getId());
            entity.setName(author.getName());
            entity.setLastName(author.getLastName());
            entity.setBooks(author.getBooks());
        }
    }

    @Override
    public void deleteAuthorById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return dao.findAllAuthors();
    }

    @Override
    public List<Book> findAllBooksByAuthor(int authorId) {
        return findAllBooksByAuthor(authorId);
    }
}
