package com.lc.springdev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@MapperScan(basePackages = "com.lc.springdev.mapper")
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value = {com.lc.springdev.listener.TestListener.class})})
public class SpringdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdevApplication.class, args);
    }

}
