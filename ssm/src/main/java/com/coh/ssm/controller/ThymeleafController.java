package com.coh.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/leaf")
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
