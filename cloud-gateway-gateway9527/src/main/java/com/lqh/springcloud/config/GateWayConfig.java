package com.lqh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/17 17:48
 * @Version 1.0
 **/
@Configuration
public class GateWayConfig {



    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_build",r ->
        {return r.path("/guonei").uri("http://news.baidu.com/guonei");
        });
        return routes.build();
    }



}
