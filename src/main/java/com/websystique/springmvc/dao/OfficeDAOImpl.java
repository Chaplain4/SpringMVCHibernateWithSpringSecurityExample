package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("officeDao")
public class OfficeDAOImpl extends AbstractDao<Integer, Office> implements OfficeDAO {
    static final Logger logger = LoggerFactory.getLogger(OfficeDAOImpl.class);

    @Override
    public Office findById(int id) {
        Office office = getByKey(id);
        return office;
    }

    @Override
    public void save(Office office) {
        persist(office);
    }

    @Override
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Office office = (Office) crit.uniqueResult();
        delete(office);
    }

    @Override
    public List<Office> findAllOffices() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();
        return offices;
    }
}
