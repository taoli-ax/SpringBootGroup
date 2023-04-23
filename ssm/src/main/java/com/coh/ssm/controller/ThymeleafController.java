package com.coh.ssm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Api("Thymeleaf")
@Controller
public class ThymeleafController {

    @RequestMapping("/leaf")
    @ApiOperation("leaf")
    public String get(Model model){
        model.addAttribute("1",1);
        return "leafs";
    }

    @RequestMapping("/thymeleaf")
    public String greeting(Model model){
        model.addAttribute("hello","thymeleaf");
        return "greeting";
    }
}
