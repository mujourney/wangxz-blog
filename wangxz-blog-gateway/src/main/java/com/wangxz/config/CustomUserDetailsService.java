package com.wangxz.config;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义UserDetailsService，用于获取用户数据来源
 * Created by zzmar on 2017/7/25.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    //重写loadUserByUsername 方法获得 userdetails 类型用户
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // ====== 开发阶段，暂时写死 ======
        // 获取用户信息
        User user = new User("user","pass",null);

//        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }

//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        //用于添加用户的权限。把用户权限添加到authorities
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            logger.info("loadUserByUsername: " + user);
//        }
//        user.setGrantedAuthorities(authorities);
        //=========== 开发 =============
        return user;
    }

}