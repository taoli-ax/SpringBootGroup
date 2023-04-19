package org.example.controller;

import org.example.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {
    @Value("${country.hello}")
    private String country;
    @Value("${user1}")
    private String user1;

    @Value("${customer[1]}")
    private String customer;
    @Value("${Win.dir}")
    private String dir;

    @Value("${tmp.dir}")
    private String tmpdir;

    @Autowired
    private MyDataSource dataSource;

    @Autowired
    private Environment environment;

    @GetMapping
    public String Home(){

        return  "Hello World!"
                +country+" "+
                user1+" "+
                customer+":"+
                dir+" "+
                tmpdir+
                environment.getProperty("server.port")+" "
                +environment.getProperty("win.element[1]")+" "+ dataSource.toString();
    }
}
