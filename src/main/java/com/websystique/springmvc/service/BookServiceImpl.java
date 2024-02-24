package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.BookDAO;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO dao;

    @Override
    public Book findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveBook(Book book) {
        dao.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book entity = dao.findById(book.getId());
        if (entity != null) {
            entity.setId(book.getId());
            entity.setName(book.getName());
            entity.setCategory(book.getCategory());
            entity.setPages(book.getPages());
        }
    }

    @Override
    public void deleteBookById(int id) {
        dao.deleteById(id);
    }


    @Override
    public List<Book> findAllBooks() {
        return dao.findAllBooks();
    }
}
