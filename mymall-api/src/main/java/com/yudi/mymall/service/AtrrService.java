package com.yudi.mymall.service;

import com.yudi.mymall.pojo.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-12 20:03
 */
public interface AtrrService {

     List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

     void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
