package com.coh.ssm.controller;


import com.coh.ssm.dao.Coh2CampDao;
import com.coh.ssm.pojo.Coh2Camp;
import com.coh.ssm.service.CoH2CampService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/CoH2")
public class CoH2CampController {
    @Autowired
    CoH2CampService coH2CampService;

    @GetMapping("/{PageNum}/{PageSize}")
    public Result getAll(@PathVariable("PageNum") Integer PageNum,@PathVariable("PageSize") Integer PageSize, Coh2Camp camp){
        System.out.println("CoH2CampController.getAll");
        System.out.println(PageNum+" "+PageSize);
        PageInfo<Coh2Camp> coh2Camps =coH2CampService.getAll(PageNum, PageSize,camp);
        return new Result(true,coh2Camps,"OK");
    }

    @PutMapping
    public Result updateCamp(@RequestBody Coh2Camp coh2Camp){
        int num=coH2CampService.updateCamp(coh2Camp);
        return new Result(true,num,"OK");
    }

    @DeleteMapping("/{id}")
    public Result deleteCamp(@PathVariable("id") int id){
        int num=coH2CampService.deleteCamp(id);
        return new Result(true,num,"OK");
    }

    @PostMapping("/new")
    public Result addOne(@RequestBody  Coh2Camp coh2Camp){
        System.out.println("CoH2CampController.addOne"+coh2Camp);
        coh2Camp.setCreate_at(new Date());
        int i=coH2CampService.addOne(coh2Camp);
        System.out.println(i);
        return new Result(true,i,"OK");
    }
}
