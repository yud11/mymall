package com.yudi.mymall.service;

import com.yudi.mymall.pojo.PmsBaseAttrInfo;
import com.yudi.mymall.pojo.PmsBaseAttrValue;
import com.yudi.mymall.pojo.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-12 20:03
 */
public interface AtrrService {

     List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

     void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList(String attrId);
}
