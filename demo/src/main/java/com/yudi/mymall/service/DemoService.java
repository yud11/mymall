package com.yudi.mymall.service;

import com.yudi.mymall.dao.UserMapper;
import com.yudi.mymall.pojo.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private UserMapper userMapper;


    public List<UmsMember> getAllUser(){
        return userMapper.getAllUser();
    }



}
