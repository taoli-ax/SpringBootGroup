package com.coh.ssm.service;

import com.coh.ssm.pojo.Cup;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CupService {
    List<Cup> findAll();
    Cup findById(Cup cup);
    PageInfo <Cup> Search(int PageNum,int PageSize,Cup cup);
    PageInfo <Cup> findByPageInfo(int PageNum, int PageSize);

    int update(Cup cup);

    int delete(int id);

    int create(Cup cup);

    int MapperScan();


}
