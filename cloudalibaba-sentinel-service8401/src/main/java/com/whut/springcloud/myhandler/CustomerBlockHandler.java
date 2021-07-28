package com.whut.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException ex){
        return new CommonResult(444,"按自定义处理,handlerException----1");
    }

    public static CommonResult handlerException2(BlockException ex){
        return new CommonResult(444,"按自定义处理,handlerException----2");
    }

}
