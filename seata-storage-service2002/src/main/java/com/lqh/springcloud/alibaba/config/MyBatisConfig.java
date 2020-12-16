package com.lqh.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.lqh.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
