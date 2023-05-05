package com.coh.ssm.controller;

import com.coh.ssm.exception.MyCustomException;
import com.coh.ssm.pojo.Cup;
import com.coh.ssm.service.CupService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cups")
public class CupController {
    //
    private static final Logger log= LoggerFactory.getLogger(CupController.class);

    @Autowired
    private CupService cupService;


    @GetMapping("/pageNation1/{PageNum}/{PageSize}")
    public Result PageNation1(@PathVariable("PageNum") Integer PageNum,@PathVariable("PageSize") Integer PageSize){

        System.out.println("CupController.PageNation1"+PageNum+","+PageSize);
        PageInfo<Cup> cupPageInfo=cupService.findByPageInfo(PageNum,PageSize);
        System.out.println("Controller hot deploy active!");

        if(cupPageInfo!=null){
            return new Result(true,cupPageInfo,"OK");
        }else {
            return new Result(false,null,"NOK");
        }
    }
    @PostMapping("/pageNation2/{PageNum}/{PageSize}")
    public Result PageNation2(@PathVariable("PageNum") Integer PageNum,@PathVariable("PageSize") Integer PageSize,Cup cup){

        System.out.println("CupController.PageNation1"+PageNum+","+PageSize+" cup:"+cup);
        PageInfo<Cup> cupPageInfo=cupService.Search(PageNum,PageSize,cup);
        System.out.println("Controller hot deploy active!");

        if(cupPageInfo!=null){
            return new Result(true,cupPageInfo,"OK");
        }else {
            return new Result(false,null,"NOK");
        }
//        return null;
    }


    @GetMapping("/{name}/{brand}")
    public Result FindById(Cup cup){
        Cup cup1=cupService.findById(cup);
        return new Result(true, cup1,"OK");
    }

    @GetMapping
    public Result  FindAll(){
        List<Cup>cupList=cupService.findAll();
        if (cupList!=null){
            return new Result(true,cupList,"OK");
        }else {
            return new Result(false,null,"NOK");
        }
    }

    @PutMapping
    public Result Update(@RequestBody Cup cup){
        return new Result(true,cupService.update(cup),"OK");
    }

    @PostMapping
    public int create(@RequestBody Cup cup){
        System.out.println(cup.toString());
        return cupService.create(cup);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") int id) throws Exception {
        System.out.println("CupController.delete");
        return new Result(true,cupService.delete(id),"OK");
    }

}
