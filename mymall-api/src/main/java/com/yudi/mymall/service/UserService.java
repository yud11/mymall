package com.yudi.mymall.service;

import com.yudi.mymall.pojo.UmsMember;
import com.yudi.mymall.pojo.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-07 8:59
 */
public interface UserService {

    public List<UmsMember> getAllUser();

    public List<UmsMemberReceiveAddress> getAddress(String memberId);
}
