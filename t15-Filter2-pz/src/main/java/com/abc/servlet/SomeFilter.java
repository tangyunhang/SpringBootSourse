package com.abc.servlet;

import com.abc.requestWrapper.MyRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;


public class SomeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("信息已被过滤");
        MyRequestWrapper req = new MyRequestWrapper((HttpServletRequest) servletRequest);
        req.addParameter("calss","dddd");
        req.addParameter("teacher","王老师");
        if(req.getParameter("type").equals("o6po")){
            req.modifyParameter("type","reporto6po");
        }
        filterChain.doFilter(req,servletResponse);

    }
}
