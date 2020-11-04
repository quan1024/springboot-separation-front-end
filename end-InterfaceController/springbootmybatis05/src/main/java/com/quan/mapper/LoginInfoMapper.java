package com.quan.mapper;

import com.quan.entity.LoginInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginInfoMapper {
    int checkAll(String username,String password);
    void addUser(String username,String password);
    int updateUser(String username,String password);
}
