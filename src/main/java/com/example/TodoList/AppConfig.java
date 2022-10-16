package com.example.TodoList;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<requestFilter> requestFilterFilterRegistrationBean(){
        FilterRegistrationBean<requestFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new requestFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}
