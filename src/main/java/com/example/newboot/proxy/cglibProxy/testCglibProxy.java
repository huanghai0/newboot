package com.example.newboot.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class testCglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new AutoMethodInterceptor());

        UserService userService = (UserService) enhancer.create();
        userService.saveUser();
    }
}
