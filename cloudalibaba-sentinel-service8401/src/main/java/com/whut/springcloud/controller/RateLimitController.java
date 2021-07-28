package com.whut.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import com.whut.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"资源名称限流测试",new Payment("2021","serial001"));
    }
    public CommonResult handleException(BlockException ex){
        return new CommonResult(444,ex.getClass().getCanonicalName()+"服务不可用");
    }

    // @GetMapping("/byUrl") // 簇点链路只能显示一层目录，两层的话不显示，显示的是@SentinelResource中的value值
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public CommonResult byUrl() {
        return new CommonResult(200,"按url限流测试OK",new Payment("2021","serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200,"按自定义处理",new Payment("2021","serial003"));
    }

}
