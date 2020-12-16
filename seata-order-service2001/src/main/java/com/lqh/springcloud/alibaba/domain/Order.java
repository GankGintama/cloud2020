package com.lqh.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/12/11 11:13
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**订单状态 0：创建中；1：已完结*/
    private Integer status;


}
