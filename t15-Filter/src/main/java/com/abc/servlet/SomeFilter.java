package com.abc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;

@WebFilter("/*")
public class SomeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("信息已被过滤");
        HttpServletRequestWrapper req = new HttpServletRequestWrapper((HttpServletRequest) servletRequest);
        Map<String,String[]> map = req.getParameterMap();
        String[] st = new String[]{"ddd"};
        map.put("calss",st);
        map.getOrDefault("teacher",new String[]{"王老师"});
        if(map.get("type")[0].equals("06po")){
            map.get("type")[0] = "reporto6po";
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
