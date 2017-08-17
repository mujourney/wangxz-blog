package com.wangxz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * Created by zzmar on 2017/8/17.
 */
@Controller
public class Login {

    private final Log logger = LogFactory.getLog(getClass());

    /**
     * 登陆页面，当登陆失败和退出登录时也会重定向到这里并携带相应的值
     * @param model ModelAndView
     * @param error 登陆失败时携带的Get参数
     * @param logout 登出时携带的Get参数
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            ModelAndView model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout
    ) {

        if(logger.isDebugEnabled()){
            logger.debug("login error: " + error + " logout: " + logout);
        }

        if (error != null) {
            model.addObject("error", "不正确的用户名和密码");
        }
        if (logout != null) {
            model.addObject("msg", "你已经成功退出");
        }
        model.setViewName("login");
        return model;
    }
}
