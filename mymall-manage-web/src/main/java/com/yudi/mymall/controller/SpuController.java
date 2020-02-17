package com.yudi.mymall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yudi.mymall.pojo.PmsProductInfo;
import com.yudi.mymall.service.SpuService;
import com.yudi.mymall.utils.PmsUploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yudi
 * @date 2020-02-16 12:53
 */
@RestController
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }

    @RequestMapping("fileUpload")
    public String upload(@RequestParam("file")MultipartFile multipartFile){
        String imageUrl = PmsUploadUtils.uploadImage(multipartFile);
        System.out.println(imageUrl);
        return imageUrl;
    }


    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
    }
}
