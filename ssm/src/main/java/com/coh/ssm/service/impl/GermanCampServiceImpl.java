package com.coh.ssm.service.impl;

import com.coh.ssm.dao.GermanCampDao;
import com.coh.ssm.pojo.German;
import com.coh.ssm.service.GermanCampService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GermanCampServiceImpl implements GermanCampService{
    @Autowired
    GermanCampDao germanCampDao;


    @Override
    public List<German> getAll() {

        return germanCampDao.getAll();
    }
}
