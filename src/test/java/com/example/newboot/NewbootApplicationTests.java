package com.example.newboot;

import com.alibaba.fastjson.JSONObject;
import com.example.newboot.utils.http.JdkHttp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class NewbootApplicationTests {

    @Autowired
    RestTemplate restTemplate;

    @Test
    void contextLoads() {
        try {
            Object response = JdkHttp.sendPost("http://www.baidu.com", "");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void restTest() {


        HttpHeaders headers = new HttpHeaders();
//相当于headers.add("Content-Type","application/json;charset=UTF-8");
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        或者添加MediaType类没有的值
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");



        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("com","ty");
        Map<String,Object> deMap = new HashMap<>();
        deMap.put("name", "设备");
        List<Object> list = new ArrayList<>();
        list.add(deMap);
        jsonMap.put("des",list);
//        logger.info("----"+JSONObject.toJSONString(jsonMap));

        HttpEntity<String> httpEntitys = new HttpEntity<>(JSONObject.toJSONString(jsonMap),headers);
        ResponseEntity<String> exchanges = restTemplate.postForEntity("http://www.baidu.com", httpEntitys, String.class);
        System.out.println(exchanges);
//        String resultRemote = exchanges.getBody();
//        Map stringToMap = JSONObject.parseObject(resultRemote);

    }


}
