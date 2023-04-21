package com.coh.ssm.exception;

import com.coh.ssm.controller.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//适用于RestController
public class MyCustomException extends RuntimeException{


    @ExceptionHandler
    public Result DoException(Exception e){
        e.printStackTrace();
        return new Result(false,e,"服务器繁忙，请稍后再试");
    }
}
