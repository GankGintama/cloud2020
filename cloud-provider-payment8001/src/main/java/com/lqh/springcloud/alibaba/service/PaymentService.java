package com.lqh.springcloud.alibaba.service;


import com.lqh.springcloud.entities.Payment;

/***
 * @Author lqh
 * @Date 17:23 2020/11/11
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
