package com.coh.ssm;

import com.coh.ssm.dao.CupDao;
import com.coh.ssm.pojo.Cup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AppTest {

    @Autowired
    private CupDao cupDao;

    @Test
    public void testMybatis(){
        List<Cup> cups=cupDao.findAll();
        System.out.println(cups);
    }
}