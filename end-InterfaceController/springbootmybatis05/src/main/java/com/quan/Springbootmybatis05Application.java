package com.quan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
@MapperScan("com.quan.mapper")
public class Springbootmybatis05Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootmybatis05Application.class, args);
    }

}
