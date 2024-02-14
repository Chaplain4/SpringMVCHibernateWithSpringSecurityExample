package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OfficeDAO;
import com.websystique.springmvc.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("officeService")
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeDAO dao;

    @Override
    public Office findById(int id) {
        return null;
    }

    @Override
    public void saveOffice(Office office) {

    }

    @Override
    public void updateOffice(Office office) {

    }

    @Override
    public void deleteOfficeById(int id) {

    }

    @Override
    public List<Office> findAllOffices() {
        return dao.findAllOffices();
    }
}
