package com.lqh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/1 18:43
 * @Version 1.0
 **/
@RestController
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    private String getConfigInfo(){
        return  configInfo;
    }
}
