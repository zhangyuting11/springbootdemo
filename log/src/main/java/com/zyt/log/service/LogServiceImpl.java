package com.zyt.log.service;

import com.zyt.log.dao.LogDao;
import com.zyt.log.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description@ // TODO
 * @create@ create by zhangyuting 2020/11/07
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao dao;

    @Override
    public int add(LogEntity entity) {
        return dao.add(entity);
    }

    @Override
    public List<LogEntity> listAll() {
        return dao.listAll();
    }
}