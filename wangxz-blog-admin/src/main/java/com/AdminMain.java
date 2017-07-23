package com;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author: wangxz
 * @Created By: 2017/7/18 下午4:37
 * @Descripyion: 后台管理系统启动类
 */
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.wangxz" })
//@ImportResource(locations={"classpath:applicationContext.xml"})
@MapperScan("com.wangxz.dao")
@EnableFeignClients
@SpringBootApplication
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class, args);
    }

}
