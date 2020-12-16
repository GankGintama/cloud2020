package com.lqh.springcloud.controller;

import com.lqh.springcloud.entities.CommonResult;
import com.lqh.springcloud.entities.Payment;
import com.lqh.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;



import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/11 17:40
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("****插入结果："+result);
       if(result > 0){
           return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
       } else{
           return new CommonResult(444,"插入数据库失败",null);
       }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){

       Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort："+serverPort,payment);
        } else{
            return new CommonResult(444,"没有对应记录，查询ID:"+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public  Object discovery(){
        List<String> servies = discoveryClient.getServices();
        for(String element: servies){
            log.info("****element:"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance :instances){
            log.info(serviceInstance.getInstanceId()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value ="/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}