package com.gxx.crm;

import com.gxx.crm.interceptors.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author gxx
 * @create 2021-07-08 14:07
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 将方法的返回值交给IOC维护
     */
    @Bean
    public NoLoginInterceptor noLoginInterceptor() {
        return new NoLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 需要一个实现了拦截器功能的实例对象，这里使用的是NoLoginInterceptor
        registry.addInterceptor(noLoginInterceptor())
                // 设置需要被拦截的资源
                .addPathPatterns("/**")
                // 设置不需要被拦截的资源
                .excludePathPatterns("/css/**", "/images/**", "/js/**", "/lib/**", "/index", "/user/login");
    }
}
