package com.quan.service;

public interface LoginInfoService {
    int checkAll(String username,String password);
    void addUser(String username,String password);
    int updateUser(String username,String password);
}
