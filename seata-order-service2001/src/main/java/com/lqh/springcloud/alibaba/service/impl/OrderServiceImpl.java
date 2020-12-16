package com.lqh.springcloud.alibaba.service.impl;

import com.lqh.springcloud.alibaba.dao.OrderDao;
import com.lqh.springcloud.alibaba.domain.Order;
import com.lqh.springcloud.alibaba.service.AccountService;
import com.lqh.springcloud.alibaba.service.OrderService;
import com.lqh.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/11 14:56
 * @Version 1.0
 **/
@Service
@Slf4j
@GlobalTransactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("--------> 开始新建订单");
        orderDao.create(order);
        log.info("--------> 订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("--------> 订单微服务开始调用账户，扣钱");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("--------> 订单微服务开始调用库存，做扣减end");
        //修改订单状态 从0到1，1代表已完成
        log.info("--->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("--->修改订单状态结束");
        log.info("---->下订单结束了，哈哈哈");

    }
}
