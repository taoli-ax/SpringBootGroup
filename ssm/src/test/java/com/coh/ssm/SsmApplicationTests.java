package com.coh.ssm;

import com.coh.ssm.dao.Coh2CampDao;
import com.coh.ssm.dao.CupDao;
import com.coh.ssm.pojo.Coh2Camp;
import com.coh.ssm.pojo.Cup;
import com.coh.ssm.service.CoH2CampService;
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
    @Autowired
    private CoH2CampService coH2CampService;
    @Autowired
    Coh2CampDao coh2CampDao;
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
        int i =cupDao.MapperScan();
        System.out.println(i);
    }

    @Test
    void  Search(){
        Cup cup=new Cup();
        cup.setName("tea");
        cupDao.Search(cup);
    }

    @Test
    void Coh2Test(){
        Coh2Camp camp=new Coh2Camp();
        camp.setCamp("east");
        List<Coh2Camp> coh2Camps=coh2CampDao.getAll(camp);
        System.out.println(coh2Camps);

    }
    @Test
    void Coh2Service(){
        Coh2Camp camp=new Coh2Camp();
        camp.setCamp("east");
        PageInfo<Coh2Camp>coh2CampPageInfo=coH2CampService.getAll(1,20,new Coh2Camp());
        System.out.println(coh2CampPageInfo);
    }

}
