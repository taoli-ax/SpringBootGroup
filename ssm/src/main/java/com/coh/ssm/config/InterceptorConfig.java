package com.coh.ssm.config;

import com.coh.ssm.interceptors.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public  void addInterceptors(InterceptorRegistry interceptorRegistry){
        InterceptorRegistration registration =interceptorRegistry.addInterceptor(new MyInterceptor());
        registration.addPathPatterns("/*");
        registration.excludePathPatterns("/leaf");

    }


}
