package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Office;


import java.util.List;

public interface OfficeService {
    Office findById(int id);

    void saveOffice(Office office);

    void updateOffice(Office office);

    void deleteOfficeById(int id);

    List<Office> findAllOffices();
}
