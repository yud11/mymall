package com.yudi.mymall.service;

import com.yudi.mymall.pojo.PmsBaseCatalog1;
import com.yudi.mymall.pojo.PmsBaseCatalog2;
import com.yudi.mymall.pojo.PmsBaseCatalog3;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-10 21:09
 */
public interface CatalogService {

    public List<PmsBaseCatalog1> getCataLog1();

    public List<PmsBaseCatalog2> getCataLog2(String catalog1Id);

    public List<PmsBaseCatalog3> getCataLog3(String catalog2Id);
}
