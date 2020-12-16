package com.lqh.springcloud.alibaba.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lqh.springcloud.alibaba.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/7 15:19
 * @Version 1.0
 **/
@Service
public class TestServiceImpl implements TestService {

    @Override
    @SentinelResource("message")
    public String getMessage() {
        return "success";
    }
}
