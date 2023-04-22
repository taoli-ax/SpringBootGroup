package com.coh.ssm.controller;

import com.coh.ssm.exception.MyCustomException;
import com.coh.ssm.pojo.Cup;
import com.coh.ssm.service.CupService;
import com.github.pagehelper.PageInfo;
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


    @PostMapping("/pageNation1/{PageNum}/{PageSize}")
    public Result PageNation1(@PathVariable("PageNum") Integer PageNum,@PathVariable("PageSize") Integer PageSize){
        PageInfo<Cup> cupPageInfo=cupService.findByPageInfo(PageNum,PageSize);
        if(cupPageInfo!=null){
            return new Result(true,cupPageInfo,"OK");
        }else {
            return new Result(false,null,"NOK");
        }
    }

    @PostMapping("/pageNation2")
    public List<Cup> PageNation2(int PageNum, int PageSize){
        return cupService.findByPage(PageNum,PageSize);
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
    public int Update(@RequestBody Cup cup){
        return cupService.update(cup);
    }

    @PostMapping
    public int create(@RequestBody Cup cup){
        return cupService.create(cup);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) throws Exception {
        if(1>0)throw new Exception();
        return cupService.delete(id);
    }

}
