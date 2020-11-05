package com.zyt.demo.base;

/**
 * @description@ // TODO Result
 * @create@ create by zhangyuting 2020/11/05
 */
public class BaseResult {
    private Integer code;
    private String msg;
    private Object data;

    public BaseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResult ok(Object data) {
        return new BaseResult(1, "成功", data);
    }

    public static BaseResult fail(String data) {
        return new BaseResult(0, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}