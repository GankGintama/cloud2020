package com.lqh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import com.lqh.springcloud.alibaba.service.IMessageProvider;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/23 19:14
 * @Version 1.0
 **/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
