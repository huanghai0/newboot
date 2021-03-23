package com.example.newboot.service;

import com.example.newboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAerospikeService {
    private final PersonRepository repository;


    @Autowired
    public MyAerospikeService(PersonRepository repository) {
        this.repository = repository;
    }

    public void doWork() {

        repository.deleteAll();

        Person person = new Person();
        person.setName("Oliver");
        person.setSex("nan");
        person = repository.save(person);

        List<Person> lastNameResults = repository.findBySex("nan");
        List<Person> firstNameResults = repository.findByName("Oli*");
    }

}
