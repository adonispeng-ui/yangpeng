package com.example.yangpeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.yangpeng.mapper") //扫描的mapper
@SpringBootApplication
public class YangpengApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangpengApplication.class, args);
    }

}
