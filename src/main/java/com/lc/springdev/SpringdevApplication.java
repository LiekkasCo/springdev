package com.lc.springdev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lc.springdev.mapper")
public class SpringdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdevApplication.class, args);
    }

}
