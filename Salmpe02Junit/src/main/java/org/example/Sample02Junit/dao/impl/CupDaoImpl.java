package org.example.Sample02Junit.dao.impl;

import org.example.Sample02Junit.dao.CupDao;
import org.springframework.stereotype.Repository;

@Repository
public class CupDaoImpl implements CupDao {

    @Override
    public void create() {
        System.out.println("CupDaoImpl.create");
    }
}
