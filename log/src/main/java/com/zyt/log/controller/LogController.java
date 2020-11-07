package com.zyt.log.controller;

import com.zyt.log.entity.LogEntity;
import com.zyt.log.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description@ // TODO log
 * @create@ create by zhangyuting 2020/11/06
 */
@Slf4j
@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    LogService logService;

    private void log(String s) {
        log.trace(s + "trace");
        log.debug(s + "debug");
        log.info(s + "info");
        log.warn(s + "warn");
        log.error(s + "error");

    }

    @RequestMapping(value = "/dev")
    public void logDev() {
        log("dev环境:");
    }

    @RequestMapping(value = "/test")
    public void logTest() {
        log("test环境:");
    }

    @RequestMapping(value = "/pro")
    public void logPro() {
        log("生产环境:");
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(LogEntity entity) {
        log.info("POST请求:/log/add");
        return ResponseEntity.ok(logService.add(entity));
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity listAll() {
        log.info("GET请求:/log/listAll");
        return ResponseEntity.ok(logService.listAll());
    }
}