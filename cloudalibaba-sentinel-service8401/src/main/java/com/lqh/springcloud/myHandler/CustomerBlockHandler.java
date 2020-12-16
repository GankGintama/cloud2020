package com.lqh.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lqh.springcloud.entities.CommonResult;
import com.lqh.springcloud.entities.Payment;
import jdk.nashorn.internal.ir.Block;

/**
 * @ClassName CustomerBlockHandler
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/8 11:25
 * @Version 1.0
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(444, "按客户自定义，global handlerExcption", new Payment(2020L,"serial1003----1"));
    }
    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(444, "按客户自定义，global handlerExcption", new Payment(2020L,"serial1003----2"));
    }
}
