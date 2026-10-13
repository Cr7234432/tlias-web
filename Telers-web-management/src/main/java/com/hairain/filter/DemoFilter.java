package com.hairain.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * ClassName:DemoFilter
 * Package: com.hairain.filter
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 20:31
 * @Version 1.0
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("filter的初始化方法运行了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("拦截了请求");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("filter的销毁方法运行了");
    }
}
