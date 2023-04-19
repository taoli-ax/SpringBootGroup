package org.example.Sample02Junit;

import org.example.Sample02Junit.dao.CupDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tests {
    @Autowired
    private CupDao cupDao;

    @Test
    void  contextLoads(){
        cupDao.create();
        System.out.println("test");
    }
}
