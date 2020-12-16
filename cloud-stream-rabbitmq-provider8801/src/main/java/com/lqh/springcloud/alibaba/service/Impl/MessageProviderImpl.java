package com.lqh.springcloud.alibaba.service.Impl;

import com.lqh.springcloud.alibaba.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/20 16:03
 * @Version 1.0
 **/
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
   @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial:"+serial);
        return null;
    }
}