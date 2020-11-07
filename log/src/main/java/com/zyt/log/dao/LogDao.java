package com.zyt.log.dao;

import com.zyt.log.entity.LogEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogDao {
    @Insert("insert into log(client_ip,server_ip,http_method,path) values(#{clientIp},#{serverIp},#{httpMethod},#{path})")
    int add(LogEntity entity);

    @Select("select * from log")
    List<LogEntity> listAll();
}
