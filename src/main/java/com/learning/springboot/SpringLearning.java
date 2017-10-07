package com.learning.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.learning.springboot.mapper")
@SpringBootApplication
@ComponentScan(basePackages = "com.learning.springboot.controller")
public class SpringLearning {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(SpringLearning.class);
        application.run(args);
    }
}
