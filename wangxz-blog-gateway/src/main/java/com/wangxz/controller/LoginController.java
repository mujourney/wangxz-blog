package com.wangxz.controller;

import com.wangxz.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {

    @Autowired
    DemoService demoService;


    @RequestMapping("/login")
    @ResponseBody
    public String user4Login() {
        demoService.test();
        return "1";
    }

    @RequestMapping("/login1")
    @ResponseBody
    public String user4Login1() {
        demoService.test();
        return "2";
    }

    @RequestMapping("/login2")
    @ResponseBody
    public String user4Login2() {
        demoService.test();
        return "3";
    }
}
