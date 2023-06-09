package com.coh.ssm.controller;

import com.coh.ssm.pojo.German;
import com.coh.ssm.service.GermanCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/germanCommander")
@RestController
public class GermanController {
    @Autowired
    GermanCampService germanCampService;
    @GetMapping
    public Result  commanders_list(){
        List<German> germanList =germanCampService.getAll();
        return new Result(true,germanList,"OK");
    }
}
