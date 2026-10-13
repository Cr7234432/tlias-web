package com.hairain.config;

import com.hairain.interceptor.DemoInterceptor;
import com.hairain.interceptor.TokenInterceptor;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:WebConfig
 * Package: com.hairain.config
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 21:30
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private DemoInterceptor demoInterceptor;

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.
                addInterceptor(tokenInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/login");
    }
}
