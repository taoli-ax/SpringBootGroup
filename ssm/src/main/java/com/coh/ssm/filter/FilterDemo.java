package com.coh.ssm.filter;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("FilterDemo.doFilter");
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
