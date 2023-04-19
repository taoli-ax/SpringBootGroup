package com.coh.test;

import com.coh.dao.CupDao;
import com.coh.pojo.Cup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest {

    @Autowired
    private CupDao cupDao;

    @Test
    public void testMybatis(){
        Cup cup=cupDao.findById(1);
        System.out.println(cup);
    }
}
