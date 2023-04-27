package com.coh.ssm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.cert.Extension;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket config(ApiInfo apiInfo){
     return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).
             select().
             apis(RequestHandlerSelectors.basePackage("com.coh.ssm.controller")).
             apis(RequestHandlerSelectors.any()).
             paths(PathSelectors.any()).
             build();
    }
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().
                title("第一次使用Swagger2").
                description("SpringBoot-Swagger集成").
                version("0.0.1").
                contact(new Contact("taoli-ax","www.google.com","springSwaggerAx@github.com")).
                build();
    }
}
