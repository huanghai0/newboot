package com.example.newboot;

import com.example.newboot.netty.service.DiscardServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com/example/newboot/mapper")
public class NewbootApplication implements CommandLineRunner {
//public class NewbootApplication{
    @Autowired
    private DiscardServer discardServer;

    public static void main(String[] args) {
        SpringApplication.run(NewbootApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        discardServer.run(8081);
    }
}
