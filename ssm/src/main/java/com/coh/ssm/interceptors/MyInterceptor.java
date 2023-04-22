package com.coh.ssm.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, java.lang.Object handler) throws java.lang.Exception {
        /* compiled code */
        System.out.println("MyInterceptor.preHandle");;
        return true;
    };

}
