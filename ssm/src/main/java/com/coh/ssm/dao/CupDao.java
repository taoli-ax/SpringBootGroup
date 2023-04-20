package com.coh.ssm.dao;

import com.coh.ssm.pojo.Cup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;
@Mapper
public interface CupDao {
    @Select("select * from cup")
    List<Cup> findAll();
}
