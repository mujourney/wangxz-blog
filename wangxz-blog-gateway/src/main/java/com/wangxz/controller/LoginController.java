package com.wangxz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description：admin登录接口
 * @Author:wangxiaozhong@winchannel.net
 * @Created:2017/07/11 下午3:43
 * @Modified By:
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Value("${name}")
    private String name;

    @RequestMapping("/login")
    @ResponseBody
    public String user4Login(){
        return  name;
    }
}
