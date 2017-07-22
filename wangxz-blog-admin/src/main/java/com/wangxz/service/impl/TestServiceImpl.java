package com.wangxz.service.impl;

import com.wangxz.dao.SysMenuMapper;
import com.wangxz.model.SysMenu;
import com.wangxz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangxz
 * @Created By: 2017/7/22 下午9:37
 * @Descripyion: demo
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public void test() {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(1);
        System.out.println(sysMenu);
    }
}
