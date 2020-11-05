package com.zyt.demo.config;

import com.zyt.demo.config.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    /*
    * @params : [registry]
    * @Description : //TODO 拦截器注册
    * @return : void
    * @Create : create by yuting 2020/11/5
    **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的url
        final String[] commonExclude = {"/notInterceptor/**"};
        registry.addInterceptor(myInterceptor).excludePathPatterns(commonExclude);
    }

    /*
    * @params : [registry]
    * @Description : //TODO 全局跨域处理,请求方法,请求头，请求地址，请求域全局配置
    * @return : void
    * @Create : create by yuting 2020/11/5
    **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedMethods("*").allowedHeaders("**").allowedOrigins("*");
    }
}