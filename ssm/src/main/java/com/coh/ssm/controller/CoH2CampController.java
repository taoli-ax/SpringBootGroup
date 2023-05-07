package com.coh.ssm.controller;


import com.coh.ssm.dao.Coh2CampDao;
import com.coh.ssm.pojo.Coh2Camp;
import com.coh.ssm.service.CoH2CampService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/CoH2")
public class CoH2CampController {
    @Autowired
    CoH2CampService coH2CampService;

    @GetMapping("/{PageNum}/{PageSize}")
    public Result getAll(@PathVariable("PageNum") Integer PageNum,@PathVariable("PageSize") Integer PageSize, Coh2Camp camp){
        System.out.println("CoH2CampController.getAll");;
        PageInfo<Coh2Camp> coh2Camps =coH2CampService.getAll(PageNum, PageSize,camp);
        return new Result(true,coh2Camps,"OK");
    }
}
