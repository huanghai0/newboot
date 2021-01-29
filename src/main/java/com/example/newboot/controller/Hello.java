package com.example.newboot.controller;


import com.example.newboot.entity.Person;
import com.example.newboot.service.PersonService;
import com.example.newboot.service.PersonService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Hello {
    @Autowired
    PersonService personService;
    @Autowired
    PersonService2 personService2;

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello My SpringBoot !";
    }

    @GetMapping("bean")
    @ResponseBody
    private String getPerson() {
        Person person = personService2.add();
        if (person != null) return "seccseful";
        return "fail";
    }

}
