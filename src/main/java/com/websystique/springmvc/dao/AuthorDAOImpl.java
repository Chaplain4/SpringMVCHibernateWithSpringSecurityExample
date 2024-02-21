package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("authorDAO")
public class AuthorDAOImpl extends AbstractDao<Integer, Author> implements AuthorDAO {
    static final Logger logger = LoggerFactory.getLogger(AuthorDAOImpl.class);

    @Autowired
    BookDAOImpl dao;

    @Override
    public Author findById(int id) {
        Author author = getByKey(id);
        return author;
    }

    @Override
    public void save(Author author) {
        persist(author);
    }

    @Override
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Author author = (Author) crit.uniqueResult();
        delete(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Author> authors = (List<Author>) criteria.list();
        return authors;
    }

    @Override
    public List<Book> findAllBooksByAuthor(int authorId) {
        Author author = findById(authorId);
        return (List<Book>) author.getBooks();
    }
}
