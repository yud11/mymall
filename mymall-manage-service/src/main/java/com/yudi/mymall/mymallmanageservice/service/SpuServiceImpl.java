package com.yudi.mymall.mymallmanageservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yudi.mymall.mymallmanageservice.mapper.PmsProductImageMapper;
import com.yudi.mymall.mymallmanageservice.mapper.PmsProductInfoMaaper;
import com.yudi.mymall.mymallmanageservice.mapper.PmsProductSaleAttrMapper;
import com.yudi.mymall.mymallmanageservice.mapper.PmsProductSaleAttrValueMapper;
import com.yudi.mymall.pojo.PmsProductImage;
import com.yudi.mymall.pojo.PmsProductInfo;
import com.yudi.mymall.pojo.PmsProductSaleAttr;
import com.yudi.mymall.pojo.PmsProductSaleAttrValue;
import com.yudi.mymall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-16 12:59
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMaaper pmsProductInfoMaaper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductInfoMaaper.select(pmsProductInfo);
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMaaper.insertSelective(pmsProductInfo);
        String pmsProductInfoId = pmsProductInfo.getId();

        //保存图片到图片表中
        List<PmsProductImage> imageList = pmsProductInfo.getPmsProductImageList();
        for (PmsProductImage pmsProductImage : imageList) {
            pmsProductImage.setProductId(pmsProductInfoId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductInfo.getPmsProductSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList) {
            pmsProductSaleAttr.setProductId(pmsProductInfoId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttr.getPmsProductSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(pmsProductInfoId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }


    }
}
