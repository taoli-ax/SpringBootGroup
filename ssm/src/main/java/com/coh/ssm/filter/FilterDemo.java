package com.coh.ssm.filter;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("FilterDemo.doFilter");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String method = httpRequest.getMethod(); // 获取请求的方法，如 GET、POST 等
        String url = httpRequest.getRequestURI(); // 获取请求的 URL
        String queryString = httpRequest.getQueryString(); // 获取请求的参数
        System.out.println(method+"-"+url+"-"+queryString);


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("FilterDemo.init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("FilterDemo.doFilter");
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
