package com.rpy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 21:53
 **/

@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class BillsAppWebConsumer {
    public static void main(String[] args) {
        SpringApplication.run(BillsAppWebConsumer.class,args);
        System.out.println("消费者启动成功");
    }
}
