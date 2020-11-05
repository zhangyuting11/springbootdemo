package com.zyt.demo.config.interceptor;

import com.zyt.demo.base.BaseException;
import com.zyt.demo.base.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description@ // TODO 全局异常处理
 * @create@ create by zhangyuting 2020/11/05
 */

@ControllerAdvice
public class MyExceptionInterceptor {

    /*
    * @params : [ex]
    * @Description : //TODO 程序异常处理
    * @return : org.springframework.http.ResponseEntity
    * @Create : create by yuting 2020/11/5
    **/
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity runtimeException(Exception ex) {
        return ResponseEntity.ok(BaseResult.fail("服务器异常"));
    }

    /*
    * @params : [e]
    * @Description : //TODO 业务异常全局处理
    * @return : org.springframework.http.ResponseEntity
    * @Create : create by yuting 2020/11/5
    **/
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public ResponseEntity businessException(BaseException e) {
        return ResponseEntity.ok(BaseResult.fail(e.getMessage()));
    }
}