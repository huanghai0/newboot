package com.example.newboot.entity;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String name;
    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
