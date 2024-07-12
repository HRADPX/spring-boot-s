package com.kuaishou.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.springboot.code.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
@Configuration
public class ApplicationProxyConfiguration {

//    @Bean
//    public ProxyInterceptor proxyInterceptor() {
//        return new ProxyInterceptor();
//    }
//
//    @Bean
//    public ProxyAdvisor proxyAdvisor() {
//        return new ProxyAdvisor();
//    }
//
//    @Bean
//    public ProxyServiceFactoryBean proxyServiceFactoryBean() {
//        return new ProxyServiceFactoryBean(new ProxyService());
//    }
//
//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
//        autoProxyCreator.setBeanNames("");
//        autoProxyCreator.setInterceptorNames("proxyInterceptor");
//        return autoProxyCreator;
//    }

    @Bean
    public TreeNode treeNode() {
        return new TreeNode(1);
    }
}
