package com.coh.ssm;

import com.coh.ssm.dao.CupDao;
import com.coh.ssm.pojo.Cup;
import com.coh.ssm.service.CupService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SsmApplicationTests {
    @Autowired
    private CupDao cupDao;
    @Autowired
    private CupService cupService;
    @Test
    void contextLoads() {
        List<Cup> cups =cupDao.findAll();
        System.out.println(cups);
    }

    @Test
    void TestPageNation(){
        PageInfo<Cup> cupPageInfo=cupService.findByPageInfo(2,5);
        System.out.println(cupPageInfo);
    }


    @Test
    void countMapperConfigScanTest(){
        int i =cupService.MapperScan();
        System.out.println(i);
    }

}
