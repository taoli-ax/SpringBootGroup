package com.coh.dao;



import com.coh.pojo.Cup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CupDao {
    @Select("select * from cup where id=#{id}")
    Cup findById(Integer id);
}
