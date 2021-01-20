package com.example.newboot.proxy.staticProxy;

public class testProxy {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserProxy userProxy = new UserProxy(userDao);
        userDao.saveUser();
    }
}
