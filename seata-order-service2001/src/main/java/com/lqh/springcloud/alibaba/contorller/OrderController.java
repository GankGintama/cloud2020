package com.lqh.springcloud.alibaba.contorller;

import com.lqh.springcloud.alibaba.domain.CommonResult;
import com.lqh.springcloud.alibaba.domain.Order;
import com.lqh.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/11 15:22
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value="/order/create")
    public CommonResult Create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
