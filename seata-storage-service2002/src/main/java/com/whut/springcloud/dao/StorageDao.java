package com.whut.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    // 修改库存
    void update(@Param("productId") Long productId, @Param("count") Integer count);

}
