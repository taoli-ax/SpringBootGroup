package com.coh.ssm.dao;

import com.coh.ssm.pojo.Cup;
import org.apache.ibatis.annotations.*;


import java.util.List;
//@Mapper
public interface CupDao {
    @Select("select * from cup")
    List<Cup> findAll();
    @Select("select * from cup where brand=#{brand} and name=#{name} ")
    Cup findById(Cup cup);
    @Update("update cup set name=#{name},brand=#{brand} where id=#{id}")
    int update(Cup cup);
    @Delete("delete from cup where id=#{id}")
    int delete(int id);

    @Insert("insert into cup values(null,#{name},#{brand})")
    int create(Cup cup);

    int  MapperScan();
}
