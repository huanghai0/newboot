package com.example.newboot.netty.service;

import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public void test() {
        System.out.println("调用service服务");
    }
}
