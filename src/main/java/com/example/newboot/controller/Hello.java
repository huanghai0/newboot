package com.example.newboot.controller;


import com.example.newboot.entity.Person;
import com.example.newboot.service.PersonService;
import com.example.newboot.service.PersonService2;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/")
public class Hello {
    @Autowired
    PersonService personService;
    @Autowired
    PersonService2 personService2;

    @Autowired
    @Qualifier("myBeanFactory")
    private BeanFactory beanFactory;

    @Autowired()
    @Qualifier("getRuleMap")
    private Map<String, String> ruleMap;

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

    @GetMapping("map")
    @ResponseBody
    private String getMap() {
        StringBuffer stringBuffer = new StringBuffer();
        ruleMap.entrySet().parallelStream().forEach((entry) -> {
            stringBuffer.append(entry.getKey() + ": " + entry.getValue() + "\n");
        });
        Map<String,String> map = (Map)beanFactory.getBean("bMap");
        return stringBuffer.toString();
    }

}
