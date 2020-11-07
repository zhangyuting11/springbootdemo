package com.zyt.log.service;

import com.zyt.log.entity.LogEntity;

import java.util.List;

public interface LogService {
    int add(LogEntity entity);

    List<LogEntity> listAll();
}
