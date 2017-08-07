package com.wangxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.RetryLoadBalancerInterceptor;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description：网关gateway
 * @Author:wangxiaozhong@winchannel.net
 * @Created:2017/07/11 下午3:31
 * @Modified By:zzmar 17/08/05
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.wangxz.fegin" })
@EnableZuulProxy
@SpringBootApplication
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class, args);
    }

    @Bean
    UserInfoRestTemplateCustomizer oauth2RestTemplateCustomizer(RetryLoadBalancerInterceptor interceptor) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(interceptor);
        // 返回一个匿名类，重写其中的customize方法用于在RestTemplate初始化前自定义RestTemplate，为其添加负载均衡性质
        return template -> {
            // 设置验证提供商
            AccessTokenProviderChain accessTokenProviderChain = Stream
                    .of(
                            // 绑定OAuth2验证器
                            new AuthorizationCodeAccessTokenProvider(),
                            new ImplicitAccessTokenProvider(),
                            new ResourceOwnerPasswordAccessTokenProvider(),
                            new ClientCredentialsAccessTokenProvider())
                    // 设置拦截器
                    .peek(tp -> tp.setInterceptors(interceptors))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), AccessTokenProviderChain::new));
            template.setAccessTokenProvider(accessTokenProviderChain);
        };
    }
}
