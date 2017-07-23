package com.wangxz.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: wangxz
 * @Created By: 2017/7/23 下午3:42
 * @Descripyion: 用户服务
 */
@FeignClient(value = "admin-server",fallback = AdminClientFallback.class)
public interface AdminClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String test();

}

class AdminClientFallback implements AdminClient {

    @Override
    public String test() {
        return null;
    }
}