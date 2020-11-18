package org.spoto.init;

import org.spoto.inceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器的配置;
@Configuration
public class WebMvcConf implements WebMvcConfigurer {

    //这么写的话，可以直接交给spring去管理;
    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/plugins/**","/css/**","/img/**","/js/**","/login.html","/login.ajax","/main.html");

    }
}
