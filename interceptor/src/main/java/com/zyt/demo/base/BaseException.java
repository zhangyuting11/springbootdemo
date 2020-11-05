package com.zyt.demo.base;

/**
 * @description@ // TODO
 * @create@ create by zhangyuting 2020/11/05
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(String message) {
        super(message);
        this.code = -1;
    }
}