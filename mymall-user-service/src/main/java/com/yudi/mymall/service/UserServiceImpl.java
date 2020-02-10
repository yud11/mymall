package com.yudi.mymall.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.yudi.mymall.dao.UmsMemberReceiveAddressMapper;
import com.yudi.mymall.dao.UserMapper;
import com.yudi.mymall.pojo.UmsMember;
import com.yudi.mymall.pojo.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;


    @Override
    public List<UmsMember> getAllUser(){
        return userMapper.selectAll();
    }


    @Override
    public List<UmsMemberReceiveAddress> getAddress(String memberId) {
        Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);
        return addressMapper.selectByExample(e);
    }
}
