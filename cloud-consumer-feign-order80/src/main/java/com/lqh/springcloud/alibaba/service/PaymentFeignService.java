package com.lqh.springcloud.alibaba.service;

import com.lqh.springcloud.entities.CommonResult;
import com.lqh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping(value ="/payment/feign/timeout")
    public String paymentFeignTimeout();
}
