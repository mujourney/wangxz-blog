package com.wangxz.service.impl;

import com.wangxz.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @Author: wangxz
 * @Created By: 2017/7/25 下午7:57
 * @Descripyion: 用户登录验证
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationProvider {

    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


//        //加密过程在这里体现
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("Wrong password.");
//        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }


}
