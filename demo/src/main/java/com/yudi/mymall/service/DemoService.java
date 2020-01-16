package com.yudi.mymall.service;

import com.yudi.mymall.dao.UmsMemberReceiveAddressMapper;
import com.yudi.mymall.dao.UserMapper;
import com.yudi.mymall.pojo.UmsMember;
import com.yudi.mymall.pojo.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;


    public List<UmsMember> getAllUser(){
        return userMapper.selectAll();
    }


    public List<UmsMemberReceiveAddress> getAddress(String memberId) {
        Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);
        return addressMapper.selectByExample(e);
    }
}
