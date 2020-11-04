package com.quan.service.impl;

import com.quan.mapper.LoginInfoMapper;
import com.quan.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginInfoService")
public class LoginInfoServiceimpl implements LoginInfoService {
    @Autowired(required=false)
    private LoginInfoMapper loginInfoMapper;
    @Override
    public int checkAll(String username, String password) {
        return loginInfoMapper.checkAll(username,password);
    }

    @Override
    public void addUser(String username, String password) {
        loginInfoMapper.addUser(username,password);
    }

    @Override
    public int updateUser(String username, String password) {
        return loginInfoMapper.updateUser(username,password);
    }
}
