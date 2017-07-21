package com.wangxz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxz
 * @Created By: 2017/7/20 下午6:33
 * @Descripyion: 测试
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${name}")
    public String name;

    @RequestMapping("/sss")
    public String tet(){
        return name;
    }
}
