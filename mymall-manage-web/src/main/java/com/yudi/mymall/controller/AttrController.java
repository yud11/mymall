package com.yudi.mymall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yudi.mymall.pojo.PmsBaseAttrInfo;
import com.yudi.mymall.pojo.PmsBaseAttrValue;
import com.yudi.mymall.pojo.PmsBaseSaleAttr;
import com.yudi.mymall.service.AtrrService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-12 10:41
 */
@RestController
@CrossOrigin
public class AttrController {
    @Reference
    private AtrrService attrService;

    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        return attrService.attrInfoList(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrService.saveAttrInfo(pmsBaseAttrInfo);
    }

    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return attrService.getAttrValueList(attrId);
    }

    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(String attrId) {
        return attrService.baseSaleAttrList(attrId);
    }

}
