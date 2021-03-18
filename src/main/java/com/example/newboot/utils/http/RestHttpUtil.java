package com.example.newboot.utils.http;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestHttpUtil {

    public static String doPost(String url, RestTemplate restTemplate, JSONObject jsonMap) {


        HttpHeaders headers = new HttpHeaders();
//相当于headers.add("Content-Type","application/json;charset=UTF-8");
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        或者添加MediaType类没有的值
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


//        logger.info("----"+JSONObject.toJSONString(jsonMap));

        HttpEntity<String> httpEntitys = new HttpEntity<>(jsonMap.toJSONString(), headers);
        ResponseEntity<String> exchanges = restTemplate.postForEntity(url, httpEntitys, String.class);
        System.out.println(exchanges);
        String resultRemote = exchanges.getBody();
//        Map stringToMap = JSONObject.parseObject(resultRemote);
        return resultRemote;
    }

}
