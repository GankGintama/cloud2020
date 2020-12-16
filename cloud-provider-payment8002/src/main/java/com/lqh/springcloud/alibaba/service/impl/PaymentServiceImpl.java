package com.lqh.springcloud.alibaba.service.impl;

import com.lqh.springcloud.dao.PaymentDao;
import com.lqh.springcloud.entities.Payment;
import com.lqh.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/11 17:24
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }
}
