package com.whut.springcloud.service.impl;

import com.whut.springcloud.dao.AccountDao;
import com.whut.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void update(Long userId, BigDecimal money) {
        log.info("开始修改账户");
        accountDao.update(userId, money);
    }

}
