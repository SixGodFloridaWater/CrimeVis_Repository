package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.system.mapper"})
public class CrimeVisApplication {

    public static void main(String[] args) {
        SpringApplication.run( CrimeVisApplication.class, args);
    }

}
