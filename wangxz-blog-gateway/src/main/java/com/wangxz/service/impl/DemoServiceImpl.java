package com.wangxz.service.impl;

import com.wangxz.fegin.AdminClient;
import com.wangxz.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangxz
 * @Created By: 2017/7/23 下午4:06
 * @Descripyion: 测试
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    AdminClient adminClient;

    @Override
    public void test() {
        String test = adminClient.test();
        System.out.println(test);
    }
}
