package com.lqh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigMain3355
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/20 9:00
 * @Version 1.0
 **/
@EnableEurekaClient
@SpringBootApplication
public class ConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class,args);
    }
}
