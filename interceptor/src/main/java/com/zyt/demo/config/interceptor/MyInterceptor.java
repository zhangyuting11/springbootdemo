package com.zyt.demo.config.interceptor;

import com.zyt.demo.base.BaseException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description@ // TODO 拦截器
 * @create@ create by zhangyuting 2020/11/05
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("preHandle:");
        //可以获取请求信息保存到数据库
        System.out.println(request.getRequestURI());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        System.out.println(request.getServerName());
        System.out.println(response.getStatus());
        System.out.println(handler);

        //拒绝未带token的访问
        if (request.getHeader("token") == null) {
            throw new BaseException("no access!");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle:");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion:");
    }
}