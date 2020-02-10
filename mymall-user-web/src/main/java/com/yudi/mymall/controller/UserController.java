package com.yudi.mymall.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.yudi.mymall.pojo.UmsMember;
import com.yudi.mymall.pojo.UmsMemberReceiveAddress;
import com.yudi.mymall.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Reference
    private UserService userService;

    @RequestMapping(value = "/")
    public List<UmsMember> getUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/getAddress")
    public List<UmsMemberReceiveAddress> getUser(@RequestParam(value = "member_id") String memberId){
        return userService.getAddress(memberId);
    }



}
