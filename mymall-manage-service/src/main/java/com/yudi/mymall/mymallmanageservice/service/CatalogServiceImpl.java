package com.yudi.mymall.mymallmanageservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yudi.mymall.mymallmanageservice.mapper.CataLog1Mapper;
import com.yudi.mymall.mymallmanageservice.mapper.CataLog2Mapper;
import com.yudi.mymall.mymallmanageservice.mapper.CataLog3Mapper;
import com.yudi.mymall.pojo.PmsBaseCatalog1;
import com.yudi.mymall.pojo.PmsBaseCatalog2;
import com.yudi.mymall.pojo.PmsBaseCatalog3;
import com.yudi.mymall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-10 21:09
 */
@Service
public class CatalogServiceImpl implements CatalogService {


    @Autowired
    private CataLog1Mapper cataLog1Mapper;

    @Autowired
    private CataLog2Mapper cataLog2Mapper;


    @Autowired
    private CataLog3Mapper cataLog3Mapper;


    @Override
    public List<PmsBaseCatalog1> getCataLog1() {
        return cataLog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCataLog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return cataLog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCataLog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return cataLog3Mapper.select(pmsBaseCatalog3);
    }
}
