package com.hairain.filter;

import com.hairain.utils.JWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * ClassName:TokenFilter
 * Package: com.hairain.filter
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 20:46
 * @Version 1.0
 */
@Slf4j
//@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest)request;
        HttpServletResponse hResponse = (HttpServletResponse)response;
        //获取请求路径
        String requestURI = hRequest.getRequestURI();
        //判断是否为登录请求，是否包含（/login），是的话，放行
        if(requestURI.contains("/login")){
            chain.doFilter(request,response);
            return;
        }
        //获取token
        String token = hRequest.getHeader("token");
        //判断token是否为空，为空返回401
        if(token == null || token.isEmpty()){
            hResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //不为空则解析，失败返回401
        try {
            JWTUtils.parseJWT(token);
        } catch (Exception e) {
            hResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //解析成功放行
        chain.doFilter(request,response);
    }
}
