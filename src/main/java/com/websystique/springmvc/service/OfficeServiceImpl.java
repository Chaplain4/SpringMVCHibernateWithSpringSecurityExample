package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OfficeDAO;
import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
@Service("officeService")
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeDAO dao;

    @Override
    public Office findById(int id) {
        Office office = dao.findById(id);
        return office;
    }

    @Override
    public void saveOffice(Office office) {
        office.setCreatedTS(new Timestamp(System.currentTimeMillis()));
        dao.save(office);
    }

    @Override
    public void updateOffice(Office office) {
        Office entity = dao.findById(office.getId());
        if(entity!=null){
            entity.setId(office.getId());
            entity.setTitle(office.getTitle());
            entity.setAddress(office.getAddress());
            entity.setPostalCode(office.getPostalCode());
            entity.setUpdatedTS(new Timestamp(System.currentTimeMillis()));
        }
    }

    @Override
    public void deleteOfficeById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Office> findAllOffices() {
        return dao.findAllOffices();
    }
}
