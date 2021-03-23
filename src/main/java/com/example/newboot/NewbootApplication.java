package com.example.newboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com/example/newboot/mapper")
public class NewbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewbootApplication.class, args);

    }

}
