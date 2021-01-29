package com.example.newboot.config;

import com.example.newboot.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean("person")
    public Person getPerson() {
        Person person = new Person("A", "女");
        return person;
    }
}
