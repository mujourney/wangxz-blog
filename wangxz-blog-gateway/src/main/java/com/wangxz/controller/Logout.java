package com.wangxz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by zzmar on 2017/8/16.
 */
@Controller
public class Logout {

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logoutPage () {
        return "logout";
    }
}