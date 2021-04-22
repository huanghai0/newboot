package com.example.newboot;

import com.example.newboot.netty.service.DiscardServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/newboot/mapper")
public class NewbootApplication implements CommandLineRunner {
    //public class NewbootApplication{
    @Autowired
    private DiscardServer discardServer;

    public static void main(String[] args) {
        System.out.println("1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        SpringApplication.run(NewbootApplication.class, args);
        System.out.println("2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("3!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        discardServer.run(8081);
        System.out.println("4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
