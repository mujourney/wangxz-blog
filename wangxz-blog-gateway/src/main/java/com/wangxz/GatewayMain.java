package com.wangxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：网关gateway
 * @Author:wangxiaozhong@winchannel.net
 * @Created:2017/07/11 下午3:31
 * @Modified By:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class, args);
    }

}
