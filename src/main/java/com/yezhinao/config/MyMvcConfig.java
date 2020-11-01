package com.yezhinao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");


        registry.addViewController("/404.html").setViewName("404");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/list.html").setViewName("list");
    }

    /**
     * 自定义的国际化组件
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }
}
