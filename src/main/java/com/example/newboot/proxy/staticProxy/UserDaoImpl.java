package com.example.newboot.proxy.staticProxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(){
        System.out.println("---保存用户---");
    }
}
