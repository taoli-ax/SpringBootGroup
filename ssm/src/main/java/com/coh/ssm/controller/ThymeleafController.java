package com.coh.ssm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Api("Thymeleaf测试")
@Controller
public class ThymeleafController {

    @GetMapping("/leaf")
    @ApiOperation("一个简单的测试方法")
    public String get(Model model){
        model.addAttribute("1",1);
        return "leafs";
    }

    @GetMapping("/thymeleaf")
    public String greeting(Model model){
        model.addAttribute("hello","thymeleaf");
        return "greeting";
    }
}
