package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficeDAO {

    Office findById(int id);

    void save(Office office);

    void deleteById(int id);

    List<Office> findAllOffices();

}
