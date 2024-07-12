package com.kuaishou.springboot.autoproxy;

import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
public class ProxyServiceFactoryBean extends ProxyFactoryBean {

    public ProxyServiceFactoryBean(ProxyService target) {
        super.setTarget(target);
//        super.setTargetSource(null);
        setInterfaces(ProxyInterface.class);
        addAdvice(new ProxyInterceptor());
        addAdvisor(new ProxyAdvisor());
        // 直接添加对象不需要任何处理，但是如果是通过setInterceptorNames 设置，
        // 则需要设置的 Interceptor 或 Advisor 则需要将它们交给 Spring 管理，
        // 因为后面需要将其转换为实例对象
//        setInterceptorNames("proxyInterceptor", "proxyAdvisor");
    }
}
