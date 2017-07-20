package com.wangxz.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: wangxz
 * @Created By: 2017/7/18 下午4:56
 * @Descripyion: 配置中心启动类
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigMain.class).web(true).run(args);
    }
}
