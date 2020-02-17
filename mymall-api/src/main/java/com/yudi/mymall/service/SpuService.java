package com.yudi.mymall.service;

import com.yudi.mymall.pojo.PmsProductInfo;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-16 12:58
 */
public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
