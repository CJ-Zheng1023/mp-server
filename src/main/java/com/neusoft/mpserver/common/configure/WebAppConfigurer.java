package com.neusoft.mpserver.common.configure;

import com.neusoft.mpserver.common.interceptor.OriginTnterceptor;
import com.neusoft.mpserver.common.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }
    @Bean
    public OriginTnterceptor getOriginTnterceptor(){
        return new OriginTnterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截
        List<String> urls = new ArrayList<String>();
        urls.add("/mark/**");
        urls.add("/search/**");
        registry.addInterceptor(getTokenInterceptor()).addPathPatterns(urls);
        //跨域拦截
        List<String> orinigUrls=new ArrayList<String>();
        orinigUrls.add("/mark/**");
        orinigUrls.add("/search/**");
        orinigUrls.add("/user/**");
        registry.addInterceptor(getOriginTnterceptor()).addPathPatterns(orinigUrls);
    }
}
