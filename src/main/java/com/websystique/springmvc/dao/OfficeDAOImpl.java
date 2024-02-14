package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("officeDao")
public class OfficeDAOImpl extends AbstractDao<Integer, Office> implements OfficeDAO {
    @Override
    public Office findById(int id) {
        return null;
    }

    @Override
    public Office findBySSO(String sso) {
        return null;
    }

    @Override
    public void save(Office office) {

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

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
        return offices;
    }
}
