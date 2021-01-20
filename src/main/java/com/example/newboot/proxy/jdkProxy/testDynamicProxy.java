package com.example.newboot.proxy.jdkProxy;

import com.example.newboot.proxy.staticProxy.UserDao;
import com.example.newboot.proxy.staticProxy.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class testDynamicProxy {

    public static void main(String[] args) {
        dynamicProxy();
    }

    public static void dynamicProxy() {
        UserDao userDao = new UserDaoImpl();
        InvocationHandler handler = new UserHander(userDao);

        ClassLoader loader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        UserDao proxy = (UserDao) Proxy.newProxyInstance(loader, interfaces, handler);

        proxy.saveUser();
    }
}
