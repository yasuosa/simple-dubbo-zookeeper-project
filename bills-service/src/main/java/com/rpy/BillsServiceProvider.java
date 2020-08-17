package com.rpy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 20:31
 **/

@SpringBootApplication
@EnableDubbo
@EnableHystrix
@MapperScan(basePackages = {"com.rpy.mapper"})
public class BillsServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(BillsServiceProvider.class,args);
        System.out.println("服务启动者启动成功");
    }
}
