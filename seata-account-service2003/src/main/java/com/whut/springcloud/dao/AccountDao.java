package com.whut.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    void update(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
