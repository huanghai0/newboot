package com.example.newboot;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.newboot.entity.Student;
import com.example.newboot.mapper.StudentDao;
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

    @Autowired
    private StudentDao studentDao;



    @Test
    public void delete() {
        studentDao.deleteById(0);
    }

    @Test
    public void wapper() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name")
                .ge("age", 18);
//        List<Student> list = studentDao.selectList(queryWrapper);
        Page<Student> list = studentDao.selectPage(new Page<Student>(1, 3), queryWrapper);
    }

    @Test
    public void insert() {
        Student student = new Student();
        student.setName("Tom6");
        student.setAge(18);
        student.setSex('男');
        studentDao.insert(student);
    }

    @Test
    public void testPage() {
        Page<Student> page = new Page<>(1, 7);
        Page<Student> studentPage = studentDao.selectPage(page, null);
        List<Student> list = studentPage.getRecords();
        long pageCount = studentPage.getPages();
        System.out.println(pageCount + "----------------------");
        list.forEach(System.out::println);

    }

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


        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("com", "ty");
        Map<String, Object> deMap = new HashMap<>();
        deMap.put("name", "设备");
        List<Object> list = new ArrayList<>();
        list.add(deMap);
        jsonMap.put("des", list);
//        logger.info("----"+JSONObject.toJSONString(jsonMap));

        HttpEntity<String> httpEntitys = new HttpEntity<>(JSONObject.toJSONString(jsonMap), headers);
        ResponseEntity<String> exchanges = restTemplate.postForEntity("http://www.baidu.com", httpEntitys, String.class);
        System.out.println(exchanges);
//        String resultRemote = exchanges.getBody();
//        Map stringToMap = JSONObject.parseObject(resultRemote);

    }


}
