package com.coh.ssm.service.impl;

import com.coh.ssm.dao.CupDao;
import com.coh.ssm.pojo.Cup;
import com.coh.ssm.service.CupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CupServiceImpl implements CupService {

    @Autowired
    private CupDao cupDao;

    @Override
    public List<Cup> findAll() {
        return cupDao.findAll();
    }

    @Override
    public Cup findById(Cup cup) {
        return cupDao.findById(cup);
    }

    @Override
    public PageInfo<Cup> Search(int PageNum, int PageSize,Cup cup) {
        PageHelper.startPage(PageNum,PageSize);
        List<Cup> cups=cupDao.Search(cup);
        return new PageInfo<>(cups);

    }

    @Override
    public PageInfo<Cup> findByPageInfo(int PageNum, int PageSize) {
        System.out.println(" service hot deploy active!");
        PageHelper.startPage(PageNum,PageSize);
        List<Cup> cups=cupDao.findAll();
        return new PageInfo<>(cups);
    }

    @Override
    public int update(Cup cup) {
        return cupDao.update(cup);
    }

    @Override
    public int delete(int id) {
        return cupDao.delete(id);
    }

    @Override
    public int create(Cup cup) {
        return cupDao.create(cup);
    }

    @Override
    public int MapperScan() {
        return cupDao.MapperScan();
    }

}
