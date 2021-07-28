package com.whut.springcloud.controller;

import com.whut.springcloud.domain.CommonResult;
import com.whut.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult update(Long productId, Integer count){
        storageService.update(productId, count);
        return new CommonResult(200,"扣减库存成功");
    }

}
