package com.yudi.mymall.mymallmanageservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yudi.mymall.mymallmanageservice.mapper.AttrInfoMapper;
import com.yudi.mymall.mymallmanageservice.mapper.AttrValMapper;
import com.yudi.mymall.mymallmanageservice.mapper.PmsBaseSaleAttrMapper;
import com.yudi.mymall.pojo.PmsBaseAttrInfo;
import com.yudi.mymall.pojo.PmsBaseAttrValue;
import com.yudi.mymall.pojo.PmsBaseSaleAttr;
import com.yudi.mymall.service.AtrrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-12 20:04
 */
@Service
public class AttrServiceImpl implements AtrrService {

    @Autowired
    private AttrInfoMapper attrInfoMapper;

    @Autowired
    private AttrValMapper attrValMapper;


    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return attrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrInfoMapper.insertSelective(pmsBaseAttrInfo);

        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            attrValMapper.insertSelective(pmsBaseAttrValue);
        }
    }


    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return attrValMapper.select(pmsBaseAttrValue);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList(String attrId) {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
