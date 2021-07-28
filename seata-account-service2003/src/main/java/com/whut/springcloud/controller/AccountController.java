package com.whut.springcloud.controller;

import com.whut.springcloud.domain.CommonResult;
import com.whut.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult update(Long userId, BigDecimal money){
        // 出现了事务问题
        int a = 10 /0;
        accountService.update(userId, money);
        return new CommonResult(200,"修改账户成功");
    }

}
