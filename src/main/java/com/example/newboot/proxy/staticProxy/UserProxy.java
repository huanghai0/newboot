package com.example.newboot.proxy.staticProxy;

public class UserProxy {
    private UserDao userDao;
    public UserProxy(UserDao userDao){
        this.userDao = userDao;
    }
    public void saveUser(){
        System.out.println("---代理开始---");
        userDao.saveUser();
        System.out.println("---代理结束---");
    }


}
