package com.kuaishou.springboot.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import com.kuaishou.springboot.autoproxy.ProxyAdvisor;
import com.kuaishou.springboot.autoproxy.ProxyInterceptor;
import com.kuaishou.springboot.autoproxy.ProxyInterface;
import com.kuaishou.springboot.autoproxy.ProxyService;
import com.kuaishou.springboot.autoproxy.ProxyServiceFactoryBean;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 *
 *
 * ProxyFactoryBean
 */
public class AutoProxyTest {

    public static void main(String[] args) {

        // 直接通过 ProxyFactory 实现代理
        ProxyFactory pf = new ProxyFactory(new Class<?>[] {ProxyInterface.class});
        pf.setTarget(new ProxyService());
        pf.addAdvisor(new ProxyAdvisor());
        pf.addAdvice(new ProxyInterceptor());


        ProxyInterface proxyInterface = (ProxyInterface) pf.getProxy();
        proxyInterface.execute("autoProxy");

        // 直接通过 addAdvisor 或  addAdvice 添加通知
        ProxyFactoryBean proxyFactoryBean = new ProxyServiceFactoryBean(new ProxyService());
        ProxyInterface proxyService = (ProxyInterface) proxyFactoryBean.getObject();
        proxyService.execute("proxyFactoryBean");

        // 通过 setInterceptorNames 设置通知需要交给 Spring 管理
        // ApplicationProxyConfiguration
//        AnnotationConfigApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(ApplicationProxyConfiguration.class);
//
//        ProxyInterface proxyService1 = applicationContext.getBean(ProxyInterface.class);
//        proxyService1.execute("proxySpring");


    }
}
