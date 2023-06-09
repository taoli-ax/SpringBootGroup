package com.coh.ssm.service.impl;

import com.coh.ssm.controller.Result;
import com.coh.ssm.dao.Coh2CampDao;
import com.coh.ssm.pojo.Coh2Camp;
import com.coh.ssm.service.CoH2CampService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class CoH2CampServiceImpl implements CoH2CampService {
    @Autowired
    Coh2CampDao coh2CampDao;

    @Override
    public PageInfo<Coh2Camp> getAll(int PageNum,int PageSize,Coh2Camp camp) {
        PageHelper.startPage(PageNum,PageSize);
        List<Coh2Camp> coh2Camps=coh2CampDao.getAll(camp);
        return new PageInfo<>(coh2Camps);

    }

    @Override
    public int updateCamp(Coh2Camp coh2Camp) {
        return coh2CampDao.updateCamp(coh2Camp);
    }

    @Override
    public int deleteCamp(int id) {
        return coh2CampDao.deleteCamp(id);
    }

    @Override
    public int addOne(Coh2Camp camp) {
        return coh2CampDao.addOne(camp);
    }


}
