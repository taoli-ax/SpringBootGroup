package com.coh.ssm.service;

import com.coh.ssm.dao.Coh2CampDao;
import com.coh.ssm.pojo.Coh2Camp;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CoH2CampService {
    PageInfo<Coh2Camp> getAll(int PageNum,int PageSize,Coh2Camp camp);

    int updateCamp(Coh2Camp coh2Camp);

    int deleteCamp(int id);

    int addOne(Coh2Camp camp);

}
