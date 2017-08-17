package com.wangxz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.KeyPair;

/**
 * Security配置
 * Created by zzmar on 2017/7/26.
 */
@EnableDiscoveryClient
@EnableWebSecurity
public class UaaSecurityConfig extends WebMvcConfigurerAdapter {

    @Bean
    FilterRegistrationBean forwardedHeaderFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new ForwardedHeaderFilter());
        filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegBean;
    }

    /**
     * 设置登录页面和验证页面的View
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
        // zzmar:使用Controller进行Login处理，移除该行
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }

    /**
     * Security 网页规则配置
     * 用户登录部分
     */
    @Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
    @Configuration
    protected static class LoginConfiguration extends WebSecurityConfigurerAdapter {

        /**
         *
         * @return
         * @throws Exception
         */
        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        /**
         * 访问权限控制
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginPage("/login")//.permitAll() zzmar: 这么使用会导致无法识别get参数，改用下面的方法
                    .and()
                    .authorizeRequests()
                    .antMatchers( "/login").permitAll() // 对login地址放行(只放行login，不包含子地址)
                    .anyRequest().authenticated()
                    .and()
                    // 登出设置
                    .logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessUrl("/login?logout");
        }

        // 用户信息供应商
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER")
                    .and()
                    .withUser("admin").password("admin").roles("ADMIN");
//            auth.parentAuthenticationManager(authenticationManager);
        }
    }

    /**
     * OAuth2验证相关
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired(required = false)
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        /**
         * jwt验证供应商
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            // 绑定证书文件
            KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray())
                    .getKeyPair("test");
            converter.setKeyPair(keyPair);
            return converter;
        }

        /**
         * 注册客户端信息供应商
         * @param clients
         * @throws Exception
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("acme")
                    .secret("acmesecret")
                    .authorizedGrantTypes("authorization_code", "refresh_token","password")
                    .scopes("openid");
        }

        /**
         * 注册token验证供应商jwt
         * @param endpoints
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
        }

        /**
         *token策略
         * @param oauthServer
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        }

    }
}
