package com.wangxz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Author: wangxz
 * @Created By: 2017/7/18 下午4:37
 * @Descripyion: 后台管理系统启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class, args);
    }

}
