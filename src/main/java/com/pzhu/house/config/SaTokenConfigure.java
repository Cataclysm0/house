package com.pzhu.house.config;

import cn.dev33.satoken.config.SaCookieConfig;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sa-Token代码方式进行配置
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    // 获取配置Bean (以代码的方式配置Sa-Token, 此配置会覆盖yml中的配置)
    @Bean
    @Primary
    public SaTokenConfig getSaTokenConfigPrimary() {
        SaTokenConfig config = new SaTokenConfig();
        config.setTokenName("satoken");             // token名称 (同时也是cookie名称)
        config.setTimeout(7 * 24 * 60 * 60);        // token有效期，单位s 7天
        config.setActivityTimeout(-1);              // token临时有效期 (指定时间内无操作就视为token过期) 单位: 秒
        config.setIsConcurrent(true);               // 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)
        config.setIsShare(false);                   // 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)
        config.setTokenStyle("tik");                // token风格
        config.setIsLog(false);                     // 是否输出操作日志
        SaCookieConfig cookieConfig = new SaCookieConfig();
        cookieConfig.setHttpOnly(false);
        config.setCookie(cookieConfig);
        return config;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义认证规则
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler)->{
            SaRouter.match("/admin/**").notMatch("/admin/login").check(r -> StpUtil.checkRole("admin"));
            SaRouter.match("/user/**").notMatch("/user/login", "/user/register").check(r -> StpUtil.checkRoleOr("admin", "common", "vip"));
        })).addPathPatterns("/**");
    }

}