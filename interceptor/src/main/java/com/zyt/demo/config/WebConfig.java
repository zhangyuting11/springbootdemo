package com.zyt.demo.config;

import com.zyt.demo.config.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description@ // TODO WebConfig
 * @create@ create by zhangyuting 2020/11/05
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的url
        final String[] commonExclude = {"/notInterceptor/**"};
        registry.addInterceptor(myInterceptor).excludePathPatterns(commonExclude);
    }
}