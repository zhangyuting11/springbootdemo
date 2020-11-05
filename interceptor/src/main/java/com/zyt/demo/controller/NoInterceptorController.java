package com.zyt.demo.controller;

import com.zyt.demo.base.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description@ // TODO NoInterceptorController
 * @create@ create by zhangyuting 2020/11/05
 */
@RestController
@RequestMapping(value = "/notInterceptor")
public class NoInterceptorController {

    @GetMapping(value = "/helloWord")
    public ResponseEntity helloWord() {
        return ResponseEntity.ok(BaseResult.ok("helloword"));
    }
}