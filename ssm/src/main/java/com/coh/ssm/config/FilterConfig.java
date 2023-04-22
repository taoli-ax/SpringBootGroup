package com.coh.ssm.config;

import com.coh.ssm.filter.FilterDemo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterDemo> RegistrationBean(){
        FilterRegistrationBean<FilterDemo> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(new FilterDemo());
        registrationBean.addUrlPatterns("/*");// setUrlPatterns 添加多个路径
        registrationBean.setOrder(1);
        registrationBean.setName("filter demo");

        return registrationBean;
    };
}
