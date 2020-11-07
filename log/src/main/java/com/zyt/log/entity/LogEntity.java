package com.zyt.log.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description@ // TODO
 * @create@ create by zhangyuting 2020/11/07
 */
@Data
public class LogEntity {
    private Integer id;
    private String clientIp;
    private String serverIp;
    private String httpMethod;
    private String path;
    private String createBy;
    private Date createTime;
}