package com.wangxz.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: wangxz
 * @Created By: 2017/7/18 下午4:19
 * @Descripyion: 注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RegistryMain.class).web(true).run(args);
    }
}
