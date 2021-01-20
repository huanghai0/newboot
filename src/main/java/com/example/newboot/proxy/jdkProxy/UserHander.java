package com.example.newboot.proxy.jdkProxy;

import com.example.newboot.proxy.staticProxy.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHander implements InvocationHandler {

    private UserDao userDao;
    public UserHander(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        saveUserStart();
        Object object = method.invoke(userDao,args);
        saveUserDone();
        return object;
    }

    public void saveUserStart(){
        System.out.println("---开始插入---");
    }

    public void saveUserDone(){
        System.out.println("---插入完成---");
    }
}
