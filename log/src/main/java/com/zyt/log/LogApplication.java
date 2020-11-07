package com.zyt.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zyt.dao")
@SpringBootApplication
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

}
