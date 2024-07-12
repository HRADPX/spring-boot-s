package com.kuaishou.springboot.methodcall.configuration;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

import com.kuaishou.springboot.methodcall.advisor.MethodCallBlockingAdvisor;
import com.kuaishou.springboot.methodcall.advisor.MethodCallBlockingInterceptor;


/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 */
@Configuration
public class MethodCallBlockingConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public MethodCallBlockingInterceptor methodCallBlockingInterceptor() {
        return new MethodCallBlockingInterceptor();
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public MethodCallBlockingAdvisor methodCallBlockingAdvisor() {
        return new MethodCallBlockingAdvisor(methodCallBlockingInterceptor());
    }
}
