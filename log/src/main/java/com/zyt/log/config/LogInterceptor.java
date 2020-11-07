package com.zyt.log.config;

import com.zyt.log.dao.LogDao;
import com.zyt.log.entity.LogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description@ // TODO
 * @create@ create by zhangyuting 2020/11/07
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Autowired
    LogDao logDao;

    @Value("${server.address}")
    private String server;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //请求日志保存
        LogEntity entity = new LogEntity();
        entity.setClientIp(request.getRemoteHost());
        entity.setServerIp(server);
        entity.setCreateBy(request.getHeader("userId"));
        entity.setHttpMethod(request.getMethod());
        entity.setPath(request.getServletPath());
        logDao.add(entity);
        //输入到日志中
        log.info("客户端IP:" + request.getRemoteHost());
        log.info("服务端IP:" + server);
        log.info("请求用户:" + request.getHeader("userId"));
        log.info("请求方法:" + request.getMethod());
        log.info("请求路径:" + request.getServletPath());
        log.info("Status:" + response.getStatus());
        return true;
    }
}