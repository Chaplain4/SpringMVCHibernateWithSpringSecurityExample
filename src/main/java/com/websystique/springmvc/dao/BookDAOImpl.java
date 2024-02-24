package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.model.Office;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("bookDao")
public class BookDAOImpl extends AbstractDao<Integer, Book> implements BookDAO {

//    @Autowired
//    AuthorDAOImpl dao;

    @Override
    public Book findById(int id) {
        Book book = getByKey(id);
        return book;
    }

    @Override
    public void save(Book book) {
        persist(book);
    }

    @Override
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Book book = (Book) crit.uniqueResult();
        delete(book);
    }


    @Override
    public List<Book> findAllBooks() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Book> books = (List<Book>) criteria.list();
        return books;
    }
}
