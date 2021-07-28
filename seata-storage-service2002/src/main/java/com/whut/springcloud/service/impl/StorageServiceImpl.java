package com.whut.springcloud.service.impl;

import com.whut.springcloud.dao.StorageDao;
import com.whut.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void update(Long productId, Integer count) {
        log.info("开始修改库存");
        storageDao.update(productId, count);
    }

}
