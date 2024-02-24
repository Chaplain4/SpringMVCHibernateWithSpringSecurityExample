package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.AuthorDAO;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Transactional
@Service("authorService")
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
        }
    }

    @Override
    public void updateAuthorBooks(Author author) {
        Author entity = dao.findById(author.getId());
        if(entity!=null){
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

}
