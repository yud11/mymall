package com.yudi.mymall.Controller;

import com.yudi.mymall.pojo.UmsMember;
import com.yudi.mymall.pojo.UmsMemberReceiveAddress;
import com.yudi.mymall.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/")
    public List<UmsMember> getUser(){
        return demoService.getAllUser();
    }

    @RequestMapping(value = "/getAddress")
    public List<UmsMemberReceiveAddress> getUser(@RequestParam(value = "member_id") String memberId){
        return demoService.getAddress(memberId);
    }



}
