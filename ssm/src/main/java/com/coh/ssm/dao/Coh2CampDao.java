package com.coh.ssm.dao;

import com.coh.ssm.pojo.Coh2Camp;

import java.util.List;

public interface Coh2CampDao {
    List<Coh2Camp> getAll(Coh2Camp camp);
    int updateCamp(Coh2Camp camp);

    int deleteCamp(int id);

    int addOne(Coh2Camp camp);
}
