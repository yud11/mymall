package com.yudi.mymall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yudi.mymall.pojo.PmsBaseCatalog1;
import com.yudi.mymall.pojo.PmsBaseCatalog2;
import com.yudi.mymall.pojo.PmsBaseCatalog3;
import com.yudi.mymall.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-10 20:55
 */
@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @RequestMapping(value = "/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){

        return catalogService.getCataLog1();
    }

    @RequestMapping(value = "/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        return catalogService.getCataLog2(catalog1Id);
    }


    @RequestMapping(value = "/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        return catalogService.getCataLog3(catalog2Id);
    }

}
